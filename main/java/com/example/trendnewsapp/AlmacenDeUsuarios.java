package com.example.trendnewsapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class AlmacenDeUsuarios {
    Context ctx;
    Usuario usuario;
    ArrayList<Usuario> lista;
    SQLiteDatabase sql;
    String bd = "AlmacenUsuario";
    String tabla = "create table if not exists usuario (id integer primary key autoincrement, nombre text, email text not null, password text not null, dni text)";

    public AlmacenDeUsuarios(Context ctx) {
        this.ctx = ctx;
        sql = ctx.openOrCreateDatabase(bd, ctx.MODE_PRIVATE, null);
        sql.execSQL(tabla);
        usuario = new Usuario();
    }

    public boolean agregarUsuario(Usuario usuario) {
        if (buscarUsuario(usuario.getEmail()) == 0) {
            ContentValues cv = new ContentValues();
            cv.put("email", usuario.getEmail());
            cv.put("password", usuario.getContraseña());
            cv.put("nombre", usuario.getNombre());
            cv.put("dni", usuario.getDni());
            return (sql.insert("usuario", null, cv) > 0);
        } else {
            return false;
        }
    }

    public int buscarUsuario(String usuarios) {
        int contador = 0;
        lista = seleccionarUsuario();
        for (Usuario usuario : lista) {
            if (usuario.getEmail().equals(usuario)) {
                contador++;
            }
        }
        return contador;
    }

    public ArrayList<Usuario> seleccionarUsuario() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista.clear();
        Cursor cursor = sql.rawQuery("select * from usuario", null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                Usuario usuarios = new Usuario();
                usuarios.setId(cursor.getInt(0));
                usuarios.setNombre(cursor.getString(1));
                usuarios.setEmail(cursor.getString(2));
                usuarios.setContraseña(cursor.getString(3));
                usuarios.setDni(cursor.getString(4));
                lista.add(usuarios);
            } while (cursor.moveToNext());
        }
        return lista;
    }

    public int login(String email, String password) {
        int contador = 0;
        Cursor cursor = sql.rawQuery("select * from usuario", null);
        if (cursor != null && cursor.moveToFirst()) {
            do {
                if (cursor.getString(2).equals(email) && cursor.getString(3).equals(password)) {
                    contador++;
                }
            } while (cursor.moveToNext());
        }
        return contador;
    }

    public Usuario getUsuario(String email, String password) {
        lista = seleccionarUsuario();

        for (Usuario usuario : lista) {
            if (usuario.getEmail().equals(email) && usuario.getContraseña().equals(password)) {
                return usuario;
            }
        }
        return null;
    }


    public Usuario getUsuarioById(int id) {
        lista = seleccionarUsuario();

        for (Usuario usuario : lista) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

}

