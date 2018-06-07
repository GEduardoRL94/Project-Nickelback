package com.isil.proyecto_ver01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView txvRegistrate;
    Button btnIniciar;
    String ruta;
    EditText edtUsuario, edtClave;
    String usuario, clave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        asignarReferencias();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        edtUsuario.setFocusable(true); //Opcional, por defecto es true.

        if(edtUsuario.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }

        txvRegistrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(i);
                MainActivity.this.finish();
            }
        });
        /*btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ActividadHerramientas.class);
                startActivity(i);
                MainActivity.this.finish();
            }
        });*/
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        ruta = "http://192.168.1.40/proyecto_android/validar_usuario.php";

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    usuario = edtUsuario.getText().toString();
                    clave = edtClave.getText().toString();
                    StringBuilder datos = new StringBuilder();
                    datos.append(usuario).append("|").append(clave);

                    URL url = new URL(ruta);

                    HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

                    httpURLConnection.setRequestMethod("POST");

                    Uri.Builder builder = new Uri.Builder().appendQueryParameter("datos",datos.toString());

                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream()));

                    bufferedWriter.write(builder.build().getEncodedQuery());
                    bufferedWriter.flush();

                    InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                    JSONArray jsonArray = new JSONArray(bufferedReader.readLine());

                    final ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
                    final int DIM = jsonArray.length();

                    for(int i = 0 ; i < DIM; i++){

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        HashMap<String, String> map = new HashMap<>();

                        map.put("nom", jsonObject.getString("nombre"));
                        map.put("ape", jsonObject.getString("apellido"));
                        map.put("eml", jsonObject.getString("email"));
                        map.put("uid", jsonObject.getString("n_usuario"));
                        map.put("pwd", jsonObject.getString("c_usuario"));

                        arrayList.add(map);

                        /*if(map.get("uid").equals(usuario) && map.get("pwd").equals(clave)){
                            validador = true;
                            arrayList.add(map);
                            break;
                        }*/

                    }

                    if(arrayList != null){

                        Intent in = new Intent(MainActivity.this, ActividadHerramientas.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("nombre", arrayList.get(0).get("nom"));
                        bundle.putString("apellido", arrayList.get(0).get("ape"));
                        bundle.putString("email", arrayList.get(0).get("eml"));
                        in.putExtras(bundle);
                        Toast.makeText(MainActivity.this, "Bienvenido "+arrayList.get(0).get("nom"), Toast.LENGTH_SHORT).show();
                        startActivity(in);
                        finish();

                    }

                    /*if(validador){
                        Intent in = new Intent(MainActivity.this, PanelActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("nombre", arrayList.get(0).get("nom"));
                        bundle.putString("apellido", arrayList.get(0).get("ape"));
                        bundle.putString("email", arrayList.get(0).get("eml"));
                        in.putExtras(bundle);
                        Toast.makeText(MainActivity.this, "Bienvenido "+arrayList.get(0).get("nom"), Toast.LENGTH_SHORT).show();
                        startActivity(in);
                        finish();
                    }else{
                        Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                    }*/

                } catch (MalformedURLException e) {

                    e.printStackTrace();

                } catch (IOException e) {

                    e.printStackTrace();

                } catch (JSONException e) {

                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    public void asignarReferencias(){

        txvRegistrate = (TextView)findViewById(R.id.txvRegistrate);
        btnIniciar = (Button)findViewById(R.id.btnIniciar);
        edtUsuario = (EditText)findViewById(R.id.edtUsuario);
        edtClave = (EditText)findViewById(R.id.edtClave);

    }
}
