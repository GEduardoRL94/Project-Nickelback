package com.isil.proyecto_ver01;

import android.content.Intent;
import android.net.Uri;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
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

public class DetalleActivity extends AppCompatActivity {

    ImageView imgFoto;
    TextView titulo, numero;
    ListView lstCanciones;
    int[] Imagenes = {
            R.drawable.curb,
            R.drawable.thestate,
            R.drawable.silver_side_up,
            R.drawable.the_long_road,
            R.drawable.all_the_right_reasons,
            R.drawable.dark_horse,
            R.drawable.here_and_now,
            R.drawable.no_fixed_address,
    };
    String ruta;
    int idAlbum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        asignarReferencias();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        ruta = "http://192.168.1.40/proyecto_android/consultar_canciones.php";

        Datos obj = (Datos)getIntent().getExtras().getSerializable("objeto");

        titulo.setText(obj.getTitulo());


        switch (obj.getImagen()){
            case R.drawable.curb_circular:
                imgFoto.setImageResource(Imagenes[0]);
                idAlbum = 1;
                poblarLista(idAlbum);
                break;
            case R.drawable.the_state_circular:
                imgFoto.setImageResource(Imagenes[1]);
                idAlbum = 2;
                poblarLista(idAlbum);
                break;
            case R.drawable.silver_side_up_circular:
                imgFoto.setImageResource(Imagenes[2]);
                idAlbum = 3;
                poblarLista(idAlbum);
                break;
            case R.drawable.the_long_road_circular:
                imgFoto.setImageResource(Imagenes[3]);
                idAlbum = 4;
                poblarLista(idAlbum);
                break;
            case R.drawable.all_the_right_reasons_circular:
                imgFoto.setImageResource(Imagenes[4]);
                idAlbum = 5;
                poblarLista(idAlbum);
                break;
            case R.drawable.dark_horse_circular:
                imgFoto.setImageResource(Imagenes[5]);
                idAlbum = 6;
                poblarLista(idAlbum);
                break;
            case R.drawable.here_and_now_circular:
                imgFoto.setImageResource(Imagenes[6]);
                idAlbum = 7;
                poblarLista(idAlbum);
                break;
            case R.drawable.no_fixed_address_circular:
                imgFoto.setImageResource(Imagenes[7]);
                idAlbum = 8;
                poblarLista(idAlbum);
                break;
        }


    }

    public void asignarReferencias(){

        imgFoto = (ImageView)findViewById(R.id.imgFoto);
        titulo = (TextView)findViewById(R.id.txvTitulo);
        lstCanciones = (ListView)findViewById(R.id.lstCanciones);
        numero = (TextView)findViewById(R.id.txvNumero);

    }

    public void poblarLista(int idAlbum){

        try{

            URL url = new URL(ruta);

            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

            httpURLConnection.setRequestMethod("POST");

            Uri.Builder builder = new Uri.Builder().appendQueryParameter("idAlbum", idAlbum+"");

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

                map.put("num", (i+1)+"");
                map.put("can", jsonObject.getString("cancion"));

                arrayList.add(map);

            }

            ListAdapter adapter = new SimpleAdapter(DetalleActivity.this, arrayList, R.layout.item_canciones,
                    new String[] {"num", "can"}, new int[]{R.id.txvNumero, R.id.txvCancion}
            );

            lstCanciones.setAdapter(adapter);

            lstCanciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Bundle datos = new Bundle();

                    datos.putString("nombre", arrayList.get(position).get("can"));

                    Intent i = new Intent(DetalleActivity.this, SoundActivity.class);

                    i.putExtras(datos);

                    startActivity(i);

                }
            });

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } catch (JSONException e) {

            e.printStackTrace();

        }



    }

}
