package com.example.gestionroles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Lider extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lider);

        Toast.makeText(this, "Nombre: =>>" +getIntent().getExtras().getString("nombre"), Toast.LENGTH_SHORT).show();
    }
}