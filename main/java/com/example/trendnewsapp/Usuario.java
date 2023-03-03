package com.example.trendnewsapp;

import android.widget.Toast;

public class Usuario {
    private int id;
    private String nombre;
    private String email;
    private String dni;
    private String contraseña;

    public Usuario() {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.contraseña = contraseña;
    }

    public boolean isNull(){
        if(nombre.equals("") && email.equals("") && dni.equals("") && contraseña.equals("")){
            return false;
        }else{
            return true;
        }
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", dni='" + dni + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }

}
