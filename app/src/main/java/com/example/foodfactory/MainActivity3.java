package com.example.foodfactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodfactory.FirebaseDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private FirebaseDatabaseHelper mDatabaseHelper;
    private List<Producto> mModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mDatabaseHelper = new FirebaseDatabaseHelper();
        readData();
    }

    private void readData(){
        mDatabaseHelper.readModels(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Producto> models, List<String> keys) {
                // Guardar los modelos y las claves para usar posteriormente
                mModels = models;
                // Actualizar la interfaz de usuario con los datos deseados
                // por ejemplo, puedes utilizar un RecyclerView para mostrar los datos
            }

            @Override
            public void DataIsInserted() {
                // Aquí puedes realizar cualquier acción después de insertar datos en la base de datos
            }

            @Override
            public void DataIsUpdated() {
                // Aquí puedes realizar cualquier acción después de actualizar datos en la base de datos
            }

            @Override
            public void DataIsDeleted() {
                // Aquí puedes realizar cualquier acción después de eliminar datos de la base de datos
            }
        });
    }

    private void insertData(){
        // Crea un objeto YourModel con los datos que desees insertar en la base de datos
        Producto model = new Producto();
        // Llama al método addModel del FirebaseDatabaseHelper para insertar el modelo en la base de datos
        mDatabaseHelper.addModel(model, new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsInserted() {
                // Aquí puedes realizar cualquier acción después de insertar datos en la base de datos
            }

            @Override
            public void DataIsLoaded(List<Producto> models, List<String> keys) {
                // No se utiliza en este caso
            }

            @Override
            public void DataIsUpdated() {
                // No se utiliza en este caso
            }

            @Override
            public void DataIsDeleted() {
                // No se utiliza en este caso
            }
        });
    }

    // Implementa los métodos para realizar las operaciones CRUD que necesites
    // utilizando los métodos correspondientes del FirebaseDatabaseHelper

    // ...
    public void abreActivity4(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity4.class);
        view.getContext().startActivity(intent);
    }

    public void abreActivity5(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity5.class);
        view.getContext().startActivity(intent);
    }

    public void abreActivity6(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity6.class);
        view.getContext().startActivity(intent);
    }

    public void abreActivity7(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity7.class);
        view.getContext().startActivity(intent);
    }
}
