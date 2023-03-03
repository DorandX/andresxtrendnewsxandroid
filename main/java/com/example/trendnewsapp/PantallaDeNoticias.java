package com.example.trendnewsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.time.LocalDate;

public class PantallaDeNoticias extends AppCompatActivity {
    private RecyclerView noticiasRecyclerView;

    private AdaptadorDeNoticias adaptadorDeNoticias;

    private Button btnAboutMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pantalla_de_noticias);
        noticiasRecyclerView = findViewById(R.id.noticiasRecyclerView);
        noticiasRecyclerView.setHasFixedSize(true);
        btnAboutMe = findViewById(R.id.btnAbMe);
        btnAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PantallaDeNoticias.this, AboutMe.class);
                startActivity(intent);
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Noticia[] noticia = {
                    new Noticia(R.drawable.arcoexpo, "Andy Lopez", "ARCO: No es una unidad rigida sino muchas maneras de ver", "Madrid se llena de color y cultura latina", LocalDate.parse("2023-02-23")),
                    new Noticia(R.drawable.guerrapalestina, "Monica Perez", "Isreaelies y palestinos, inmersos en una espiral cada vez mas peligrosa ", "El pueblo palestino no ve aun la luz al final del tunel en un escenario apocaliptico", LocalDate.parse("2023-02-23")),
                    new Noticia(R.drawable.eurovisioncontest, "Danilo Rodriguez", "Eurovision 2023: Cuando y donde el festival ", "Blanca Paloma, ganadora del Benidorm Fest 2023, será la representante de España en el festival de Eurovisión", LocalDate.parse("2023-02-23")),
                    new Noticia(R.drawable.presidenteenucrania, "Raul Piña", "Madrid y Kiev abiertos a ayuda aérea y envío de vehículos Leopard para Ucrania ", "El presidente del Gobierno ha llegado a Kiev en tren desde Polonia a un día del primer aniversario de la guerra", LocalDate.parse("2023-02-23")),
                    new Noticia(R.drawable.barcelonahubs, "Javier Sanchez", "Cisco abre nuevo centro de diseño de semiconductores en Barcelona", "El 10 de noviembre de 2022, Cisco comunicó la creación de un centro de diseño de semiconductores de nueva generación en Barcelona", LocalDate.parse("2023-02-23"))
            };
            adaptadorDeNoticias = new AdaptadorDeNoticias(noticia, PantallaDeNoticias.this);
            noticiasRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            noticiasRecyclerView.setAdapter(adaptadorDeNoticias);
        }

    }}