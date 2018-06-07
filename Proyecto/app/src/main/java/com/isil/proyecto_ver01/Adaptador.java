package com.isil.proyecto_ver01;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends BaseAdapter {

    Context contexto;
    List<Datos> listaObjetos;

    public Adaptador(Context contexto, List<Datos> listaObjetos) {
        this.contexto = contexto;
        this.listaObjetos = listaObjetos;
    }

    @Override
    public int getCount() {
        return listaObjetos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaObjetos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaObjetos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Inflate permite vincular el layout a un item del list view.
        View vista = convertView;
        LayoutInflater inflate = LayoutInflater.from(contexto);
        vista = inflate.inflate(R.layout.itemlistview, null);

        ImageView imagen = (ImageView)vista.findViewById(R.id.imageView);
        TextView titulo = (TextView)vista.findViewById(R.id.txvTitulo);
        TextView detalle = (TextView)vista.findViewById(R.id.txvDetalle);

        titulo.setText(listaObjetos.get(position).getTitulo().toString());
        detalle.setText(listaObjetos.get(position).getDetalle().toString());
        imagen.setImageResource(listaObjetos.get(position).getImagen());

        return vista;

    }
}
