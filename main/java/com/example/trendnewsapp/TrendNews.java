package com.example.trendnewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class TrendNews extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();


        setContentView(R.layout.activity_main);


        Animation animacionQueSube = AnimationUtils.loadAnimation(this, R.anim.mover_hacia_arriba);
        Animation animacionQueBaja = AnimationUtils.loadAnimation(this, R.anim.mover_hacia_abajo);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textoBienvenidaEntrada = findViewById(R.id.tvBienvenidoEntrada);
        TextView trendNewsTv = findViewById(R.id.txTrendNews);
        ImageView imgMoscaTn = findViewById(R.id.imgMoscaTN);
        ImageView imagenPeriodico = findViewById(R.id.imgPeriodico);
        TextView textoIntro = findViewById(R.id.txvIntro);

        textoBienvenidaEntrada.setAnimation(animacionQueBaja);
        trendNewsTv.setAnimation(animacionQueBaja);
        imgMoscaTn.setAnimation(animacionQueSube);
        imagenPeriodico.setAnimation(animacionQueBaja);
        textoIntro.setAnimation(animacionQueSube);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(TrendNews.this, IniciarSesion.class);

                // No me termina como queda la animación, dejo default
                Pair[] pairs = new Pair[4];
                pairs[0] = new Pair<View, String>(imgMoscaTn, "transicionLogo");
                pairs[1] = new Pair<View, String>(trendNewsTv, "transicionTexto");
                pairs[2] = new Pair<View, String>(imagenPeriodico,"transicionPeriodico");
                pairs[3] = new Pair<View, String>(textoIntro,"transicionTextoIntro");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(TrendNews.this, pairs);
                startActivity(intent, options.toBundle());
                //startActivity(intent);
                finish();
            }
        }, 2600);
    }
}
