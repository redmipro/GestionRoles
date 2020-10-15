package com.example.gestionroles;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Date extends SQLiteOpenHelper {

    public Date(Context context){
        super(context, "votantes", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE votante (cedula integer primary key,nombre text, correo text, telefono TEXT, direccion, lugar_de_votacion text);";
        query+= "CREATE TABLE usuario(cod integer primary key, nombre text, apellido text, tipo integer)";
        query+= "Insert into usuario(87933, 'juan', 'perez',0, 'contra123'),(76474,'pedro','rivaz',1, 'contrasena123'), (23412,'claudio', 'alonso', 2, '123456')";
        /*
        * candidato = 0;
        * coordinador = 1;
        * lider = 2; */
        db.execSQL(query);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
