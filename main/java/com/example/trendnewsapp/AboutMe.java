package com.example.trendnewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutMe extends AppCompatActivity {

    private Button btnVolverAbMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_about_me);

        btnVolverAbMe = findViewById(R.id.btnVolverAbMe);
        btnVolverAbMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AboutMe.this, PantallaDeNoticias.class);
                startActivity(intent);
            }
        });
    }
}
