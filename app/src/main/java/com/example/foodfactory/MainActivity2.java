package com.example.foodfactory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void abreActivity3(View view) {
        Intent intent = new Intent(view.getContext(), MainActivity3.class);
        view.getContext().startActivity(intent);
    }
}