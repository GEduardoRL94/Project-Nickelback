package com.isil.proyecto_ver01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class ActividadHerramientas extends AppCompatActivity {

    ListView listaDatos;
    ArrayList<Datos> Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_herramientas);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        asignarReferencias();
        Lista = new ArrayList<>();

        Lista.add(new Datos(1, "1996 - Curb", "12 canciones", R.drawable.curb_circular));
        Lista.add(new Datos(2, "1999 - The State", "11 canciones", R.drawable.the_state_circular));
        Lista.add(new Datos(3, "2001 - Silver Side Up", "11 canciones", R.drawable.silver_side_up_circular));
        Lista.add(new Datos(4, "2003 - The Long Road", "11 canciones", R.drawable.the_long_road_circular));
        Lista.add(new Datos(5, "2005 - All The Right Reasons", "12 canciones", R.drawable.all_the_right_reasons_circular));
        Lista.add(new Datos(6, "2008 - Dark Horse", "11 canciones", R.drawable.dark_horse_circular));
        Lista.add(new Datos(7, "2011 - Here And Now", "12 canciones", R.drawable.here_and_now_circular));
        Lista.add(new Datos(8, "2014 - No Fixed Address", "12 canciones", R.drawable.no_fixed_address_circular));

        Adaptador miAdaptador = new Adaptador(getApplicationContext(), Lista);

        listaDatos.setAdapter(miAdaptador);

        listaDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Datos obj = (Datos)parent.getItemAtPosition(position);

                Intent i = new Intent(getApplicationContext(), DetalleActivity.class);
                i.putExtra("objeto", (Serializable)obj);
                startActivity(i);

            }
        });
    }

    public void asignarReferencias(){

        listaDatos = (ListView)findViewById(R.id.lstDatos);

    }
}
