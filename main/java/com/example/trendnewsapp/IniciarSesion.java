package com.example.trendnewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextUtils;

import com.google.android.material.textfield.TextInputLayout;

public class IniciarSesion extends AppCompatActivity {
    private TextView txBienvenida, tvIrARegistro;
    private EditText etEmail, etContraseña;
    private ImageView imgLogoTrendNews, imgIconWorldNews;
    private TextInputLayout tfEmail, tfContraseña;
    private Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        getSupportActionBar().hide();

        imgLogoTrendNews = findViewById(R.id.imgMoscaTN);
        imgIconWorldNews = findViewById(R.id.imgIconWorldNews);
        txBienvenida = findViewById(R.id.tvUsuario);
        tvIrARegistro = findViewById(R.id.btnUnirme);
        tfEmail = findViewById(R.id.txfEmail);
        tfContraseña = findViewById(R.id.txfContraseña);
        btnIniciar = findViewById(R.id.btnIniciar);
        etContraseña = findViewById(R.id.txtContraseña);
        etEmail = findViewById(R.id.txtEmail);

        AlmacenDeUsuarios almacenDeUsuario = new AlmacenDeUsuarios(this);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String contraseña = etContraseña.getText().toString().trim();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(contraseña)) {
                    Toast.makeText(IniciarSesion.this, "Por favor, complete los campos vacíos", Toast.LENGTH_LONG).show();
                } else {
                    Usuario usuario = almacenDeUsuario.getUsuario(email, contraseña);
                    if (usuario != null) {
                        Toast.makeText(IniciarSesion.this, "¡Bienvenido " + usuario.getNombre() + "!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(IniciarSesion.this, PantallaDeNoticias.class);
                        intent.putExtra("usuario_nombre", usuario.getNombre());
                        intent.putExtra("usuario_email", usuario.getEmail());
                        intent.putExtra("usuario_dni", usuario.getDni());
                        intent.putExtra("usuario_contraseña", usuario.getContraseña());
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(IniciarSesion.this, "Correo o contraseña incorrectos, por favor intente de nuevo", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        tvIrARegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irARegistro();
            }
        });
    }

    public void irARegistro() {
        Intent secuencia = new Intent(IniciarSesion.this, RegistroDeUsuario.class);

        Pair[] pairs = new Pair[6];
        pairs[0] = new Pair<View, String>(imgLogoTrendNews, "transicionLogonTn");
        pairs[1] = new Pair<View, String>(txBienvenida, "transicionDeTexto");
        pairs[2] = new Pair<View, String>(tvIrARegistro, "goTransicionDeInicio");
        pairs[3] = new Pair<View, String>(tfEmail, "transicionDeEmail");
        pairs[4] = new Pair<View, String>(tfContraseña, "transicionDeContraseña");
        pairs[5] = new Pair<View, String>(btnIniciar, "transicionDeBotonRegistro");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(IniciarSesion.this, pairs);
        startActivity(secuencia, options.toBundle());
        finish();
    }
}
