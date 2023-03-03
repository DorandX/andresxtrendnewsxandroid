package com.example.trendnewsapp;

import java.io.Serializable;
import java.time.LocalDate;

public class Noticia implements Serializable {
    private int imagen;
    private String autor;
    private String titulo;
    private String descripcion;
    private LocalDate fecha;

    public Noticia(int imagen, String autor, String titulo, String descripcion, LocalDate fecha) {
        this.imagen = imagen;
        this.autor = autor;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "idImagen=" + imagen +
                ", autor='" + autor + '\'' +
                ", titulo='" + titulo + '\'' +
                ", texto='" + descripcion + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
