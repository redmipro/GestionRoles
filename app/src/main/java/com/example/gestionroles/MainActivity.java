package com.example.gestionroles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText usuario, contrasena;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.user);
        contrasena = findViewById(R.id.pass);

        btnlogin = findViewById(R.id.button);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    public void  login(){

        Intent activityNext = null;

        String usu = usuario.getText().toString();
        String pas = contrasena.getText().toString();
        Date db = new Date(getApplicationContext());
        SQLiteDatabase sqldb = db.getReadableDatabase();
        Cursor consulta = sqldb.rawQuery("Select * from usuario where cod=" +usu+ " and contrasena='" + pas+ "';", null );
        if (consulta.moveToFirst()){
            int tipo = consulta.getInt(3);
            Bundle memoria = new Bundle();
            memoria.putInt("codigo",consulta.getInt(0));
            memoria.putString("nombre", consulta.getString(1));

            if (tipo == 0) {
                activityNext = new Intent(MainActivity.this, Candidato.class);
            }
            if (tipo == 1) {
                activityNext = new Intent(MainActivity.this, Coordinador.class);
            }
            if (tipo == 2){
               activityNext = new Intent(MainActivity.this, Lider.class);
            }
            activityNext.putExtras(memoria);
            startActivity(activityNext);
        }
    }
}