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

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

public class RegistroDeUsuario extends AppCompatActivity {
    TextView rellenaLosDatos, tvIrAInicio;
    EditText etNombreDeUsuario, etDni, etEmail, etContraseña, etRepetirContraseña;
    ImageView imgImagenDeLogin;
    TextInputLayout tiNombre, tfEmail, tfDni, tfContraseña, tfRepetirContraseña;
    Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_registro_de_usuario);
        imgImagenDeLogin = findViewById(R.id.imgLoginTn);
        rellenaLosDatos = findViewById(R.id.txSolicitudRegistro);
        tvIrAInicio = findViewById(R.id.txvIrAPantallaInicio);
        tiNombre = findViewById(R.id.txNombreDeUsuario);
        tfEmail = findViewById(R.id.tfEmail);
        tfDni = findViewById(R.id.txfDni);
        tfContraseña = findViewById(R.id.tfContraseña);
        tfRepetirContraseña = findViewById(R.id.txfRepetirContraseña);
        registerButton = findViewById(R.id.btnUnirme);
        etNombreDeUsuario = findViewById(R.id.txNombre);
        etDni = findViewById(R.id.etDni);
        etEmail = findViewById(R.id.etEmail);
        etContraseña = findViewById(R.id.etContraseña);
        etRepetirContraseña = findViewById(R.id.etRepetirContraseña);
        AlmacenDeUsuarios adu = new AlmacenDeUsuarios(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario u = new Usuario();
                u.setEmail(etEmail.getText().toString());
                u.setDni(etDni.getText().toString());
                u.setNombre(etNombreDeUsuario.getText().toString());
                String password1 = etContraseña.getText().toString();
                String password2 = etRepetirContraseña.getText().toString();
                if (password1.equals(password2)) {
                    u.setContraseña(etContraseña.getText().toString());

                    if (!u.isNull()) {
                        Toast.makeText(RegistroDeUsuario.this, "Error: Hay algún campo vacío", Toast.LENGTH_LONG).show();
                    } else if (adu.agregarUsuario(u)) {
                        Toast.makeText(RegistroDeUsuario.this, "¡Registrado con éxito!", Toast.LENGTH_LONG).show();
                        irALogin();
                    } else {
                        Toast.makeText(RegistroDeUsuario.this, "Error: Usuario ya registrado", Toast.LENGTH_LONG).show();
                    }

                } else {
                    Toast.makeText(RegistroDeUsuario.this, "Error: Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
                }
            }
        });

        tvIrAInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irALogin();
            }
        });
    }

    @Override
    public void onBackPressed() {
        irALogin();
    }

    public void irALogin() {
        Intent intent = new Intent(RegistroDeUsuario.this, IniciarSesion.class);

        Pair[] pairs = new Pair[6];
        pairs[0] = new Pair<View, String>(imgImagenDeLogin, "transicionLogonTn");
        pairs[1] = new Pair<View, String>(rellenaLosDatos, "transicionDeTexto");
        pairs[2] = new Pair<View, String>(tvIrAInicio, "goTransicionDeInicio");
        pairs[3] = new Pair<View, String>(tfEmail, "transicionDeEmail");
        pairs[4] = new Pair<View, String>(tfContraseña, "transicionDeContraseña");
        pairs[5] = new Pair<View, String>(registerButton, "transicionDeBotonRegistro");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(RegistroDeUsuario.this, pairs);
        startActivity(intent, options.toBundle());
        finish();
    }
}