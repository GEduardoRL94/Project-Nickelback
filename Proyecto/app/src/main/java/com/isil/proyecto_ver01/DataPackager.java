package com.isil.proyecto_ver01;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;

public class DataPackager {

    String nombre, apellido, email, usuario, clave;


    public DataPackager(String nombre, String apellido, String email, String usuario, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario = usuario;
        this.clave = clave;
    }

    public String packData(){

        JSONObject jo = new JSONObject();

        StringBuffer packedData = new StringBuffer();

        try{

            jo.put("Nombre", nombre);
            jo.put("Apellido", apellido);
            jo.put("Email", email);
            jo.put("Usuario", usuario);
            jo.put("Clave", clave);

            Boolean firstValue = true;

            Iterator<String> it = jo.keys();

            do{

                String key = it.next().toString();
                String value = jo.get(key).toString();

                if(firstValue){

                    firstValue = false;

                }else{

                    packedData.append("&");

                }

                packedData.append(URLEncoder.encode(key, "UTF-8"));
                packedData.append("=");
                packedData.append(URLEncoder.encode(value, "UTF-8"));

            }while(it.hasNext());

            return packedData.toString();

        } catch (JSONException e) {

            e.printStackTrace();

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();

        }

        return null;

    }

}
