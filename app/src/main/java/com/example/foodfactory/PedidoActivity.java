package com.example.foodfactory;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class PedidoActivity extends AppCompatActivity {

    private TextView txtDetallePedido;
    private TextView txtTotalPagar;
    private int cantidadHamburguesas; // Cambiado a campo de instancia

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);

        txtDetallePedido = findViewById(R.id.txtDetallePedido);
        txtTotalPagar = findViewById(R.id.txtTotalPagar);

        // Recupera la cantidad de hamburguesas desde SharedPreferences
        SharedPreferences preferences = getSharedPreferences("PedidoPref", MODE_PRIVATE);
        cantidadHamburguesas = preferences.getInt("cantidadHamburguesas", 0);

        // Actualiza la interfaz con la cantidad recuperada
        txtDetallePedido.setText("Hamburguesas: " + cantidadHamburguesas);
        actualizarTotalPagar(cantidadHamburguesas);

        Button btnAgregarPedido = findViewById(R.id.btnAgregarPedido);
        Button btnEliminarPedido = findViewById(R.id.btnEliminarPedido);
        Button btnEnviarPedido = findViewById(R.id.btnEnviarPedido);

        btnAgregarPedido.setOnClickListener(v -> {
            // Lógica para agregar una hamburguesa al pedido
            cantidadHamburguesas++;
            txtDetallePedido.setText("Hamburguesas: " + cantidadHamburguesas);
            actualizarTotalPagar(cantidadHamburguesas);
        });

        btnEliminarPedido.setOnClickListener(v -> {
            // Lógica para eliminar una hamburguesa del pedido
            if (cantidadHamburguesas > 0) {
                cantidadHamburguesas--;
                txtDetallePedido.setText("Hamburguesas: " + cantidadHamburguesas);
                actualizarTotalPagar(cantidadHamburguesas);
            }
        });

        btnEnviarPedido.setOnClickListener(v -> {
            // Lógica para enviar el pedido y guardar en Firebase
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("pedidos");

            // Creamos un objeto HashMap para guardar los datos del pedido
            HashMap<String, Object> pedidoMap = new HashMap<>();
            pedidoMap.put("cantidad", cantidadHamburguesas + " hamburguesas");
            // Agrega más datos del pedido si necesario

            // Guarda los datos en la base de datos
            databaseReference.push().setValue(pedidoMap)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(PedidoActivity.this, "El pedido se ha enviado y guardado correctamente.", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(PedidoActivity.this, "Error al enviar y guardar el pedido.", Toast.LENGTH_SHORT).show();
                        }
                    });
        });

    }

    private void actualizarTotalPagar(int cantidadHamburguesas) {
        // Lógica para calcular el total a pagar basado en la cantidad de hamburguesas
        double precioUnitario = 30.00; // Reemplaza con tu lógica de precios
        double precioTotal = cantidadHamburguesas * precioUnitario;
        txtTotalPagar.setText("Total a Pagar: $" + String.format("%.2f", precioTotal));
    }
}
