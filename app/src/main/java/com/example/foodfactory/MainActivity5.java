package com.example.foodfactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {

    private int cantidadPizzas = 0;
    private TextView txtCantidad;
    private TextView txtPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        // Obtener referencias a los elementos de la interfaz
        txtCantidad = findViewById(R.id.txtCantidad);
        txtPrecio = findViewById(R.id.txtPrecio);

        Button btnAumentar = findViewById(R.id.btnAumentar);
        Button btnDisminuir = findViewById(R.id.btnDisminuir);
        Button btnGuardar = findViewById(R.id.btnGuardar);

        // Configurar ImageView para la hamburguesa
        ImageView imgPizzaPep = findViewById(R.id.imgPizzaPep);
        // Puedes cambiar el nombre del recurso según el nombre real de tu imagen
        imgPizzaPep.setImageResource(R.drawable.pizzapepperoni);

        // Configurar listeners de los botones
        btnAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementarCantidad();
                actualizarPrecio();
            }
        });

        btnDisminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disminuirCantidad();
                actualizarPrecio();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarCantidad();
            }
        });

        Button btnConfirmarPedido = findViewById(R.id.btnConfirmarPedido);
        btnConfirmarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmarPedido();
            }
        });

    }

    private void incrementarCantidad() {
        cantidadPizzas++;
        actualizarTextoCantidad();
    }

    private void disminuirCantidad() {
        if (cantidadPizzas > 0) {
            cantidadPizzas--;
            actualizarTextoCantidad();
        }
    }

    private void guardarCantidad() {
        // Aquí puedes agregar la lógica para guardar la cantidad pedida, como enviarla a una base de datos, etc.
        // En este ejemplo, simplemente mostraremos un mensaje con la cantidad.
        String mensaje = "Cantidad guardada: " + cantidadPizzas;
        // Puedes reemplazar esto con tu lógica de guardar datos.
        mostrarMensaje(mensaje);
    }

    private void actualizarTextoCantidad() {
        txtCantidad.setText(String.valueOf(cantidadPizzas));
    }

    private void actualizarPrecio() {
        double precioUnitario = 120.00; // Reemplaza con tu lógica de precios
        double precioTotal = cantidadPizzas * precioUnitario;
        txtPrecio.setText("Precio: $" + String.format("%.2f", precioTotal));
    }

    private void mostrarMensaje(String mensaje) {
        // Puedes personalizar cómo deseas mostrar mensajes al usuario, como un Toast o un AlertDialog.
        // En este ejemplo, simplemente imprimimos el mensaje en el Log.
        System.out.println(mensaje);
    }

    private void confirmarPedido() {
        // Abre la actividad de Pedido
        Intent intent = new Intent(this, PedidoActivity.class);
        startActivity(intent);
    }

    public void abreActivity3(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity3.class);
        view.getContext().startActivity(intent);
    }
}
