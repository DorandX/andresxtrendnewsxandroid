package com.example.trendnewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class PantallaDeNoticia extends AppCompatActivity {
    private TextView tituloTextView;
    private TextView fechaTextView;
    private TextView autorTextView;
    private TextView descripcionTextView;
    private ImageView imagenTxv;

    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_de_noticia);
        getSupportActionBar().hide();
        tituloTextView = findViewById(R.id.txvTituloDeNoticia);
        fechaTextView = findViewById(R.id.txvFecha);
        descripcionTextView = findViewById(R.id.txvDescripcion);
        imagenTxv = findViewById(R.id.imgTnNoticia);
        autorTextView = findViewById(R.id.txvAutor);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String titulo = extras.getString("titulo");
            String fecha = extras.getString("fecha");
            int imagenResId = extras.getInt("imagen");
            Bitmap imagen = BitmapFactory.decodeResource(getResources(), imagenResId);
            String descripcion = extras.getString("descripcion");
            String autor = extras.getString("autor");

            tituloTextView.setText(titulo);
            descripcionTextView.setText(descripcion);
            fechaTextView.setText(fecha);
            imagenTxv.setImageBitmap(imagen);
            autorTextView.setText(autor);
        }
        btnVolver = findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PantallaDeNoticia.this, PantallaDeNoticias.class);
                startActivity(intent);
            }
        });
    }
}


