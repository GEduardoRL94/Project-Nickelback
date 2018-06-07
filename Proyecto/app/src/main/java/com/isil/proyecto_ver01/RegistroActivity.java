package com.isil.proyecto_ver01;

import android.os.StrictMode;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {

    TextView txvInicia;
    EditText edtNombre, edtApellido, edtEmail, edtUsuario, edtClave;
    Button btnRegistrar;
    String urlAddress = "http://192.168.1.40/proyecto_android/insertar_usuario.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        asignarReferencias();

        edtNombre.setFocusable(true); //Opcional, por defecto es true.

        if(edtNombre.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        txvInicia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                RegistroActivity.this.finish();
            }
        });
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sender s = new Sender(RegistroActivity.this, urlAddress, edtNombre, edtApellido, edtEmail, edtUsuario, edtClave);
                s.execute();
            }
        });


    }

    public void asignarReferencias(){

        txvInicia = (TextView)findViewById(R.id.txvInicia);
        btnRegistrar = (Button)findViewById(R.id.btnRegistrar);
        edtNombre = (EditText)findViewById(R.id.edtNombre);
        edtApellido = (EditText)findViewById(R.id.edtApellido);
        edtEmail = (EditText)findViewById(R.id.edtCorreo);
        edtUsuario = (EditText)findViewById(R.id.edtUsuario);
        edtClave = (EditText)findViewById(R.id.edtClave);

    }
}
