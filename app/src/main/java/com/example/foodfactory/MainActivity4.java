package com.example.foodfactory;

import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodfactory.PedidoActivity;

public class MainActivity4 extends AppCompatActivity {

    private int cantidadHamburguesas = 0;
    private TextView txtCantidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        txtCantidad = findViewById(R.id.txtCantidad);
        Button btnAumentar = findViewById(R.id.btnAumentar);
        Button btnDisminuir = findViewById(R.id.btnDisminuir);
        Button btnGuardar = findViewById(R.id.btnGuardar);

        btnAumentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementarCantidad();
            }
        });

        btnDisminuir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disminuirCantidad();
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
        cantidadHamburguesas++;
        actualizarTextoCantidad();
    }

    private void disminuirCantidad() {
        if (cantidadHamburguesas > 0) {
            cantidadHamburguesas--;
            actualizarTextoCantidad();
        }
    }

    private void guardarCantidad() {
        // Guarda la cantidad de hamburguesas en SharedPreferences
        SharedPreferences preferences = getSharedPreferences("PedidoPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("cantidadHamburguesas", cantidadHamburguesas);
        editor.apply();

        // Muestra el mensaje
        String mensaje = "Cantidad guardada: " + cantidadHamburguesas;
        mostrarMensaje(mensaje);
    }

    private void actualizarTextoCantidad() {
        txtCantidad.setText(String.valueOf(cantidadHamburguesas));
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
