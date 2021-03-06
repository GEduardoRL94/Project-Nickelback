package com.isil.proyecto_ver01;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

public class Sender extends AsyncTask<Void, Void, String>{

    Context c;
    String urlAddress;
    EditText edtNombre, edtApellido, edtEmail, edtUsuario, edtClave;
    String nombre, apellido, email, usuario, clave;
    ProgressDialog pd;

    public Sender(Context c, String urlAddress, EditText...editTexts){

        this.c = c;
        this.urlAddress = urlAddress;

        this.edtNombre = editTexts[0];
        this.edtApellido = editTexts[1];
        this.edtEmail = editTexts[2];
        this.edtUsuario = editTexts[3];
        this.edtClave = editTexts[4];

        nombre = edtNombre.getText().toString();
        apellido = edtApellido.getText().toString();
        email = edtEmail.getText().toString();
        usuario = edtUsuario.getText().toString();
        clave = edtClave.getText().toString();

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(c);
        pd.setTitle("Send");
        pd.setMessage("Sending...Please wait");
        pd.show();
    }

    @Override
    protected String doInBackground(Void...params) {
        return this.send();
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        pd.dismiss();
        if(response != null){

            Toast.makeText(c, response, Toast.LENGTH_SHORT).show();
            edtNombre.setText("");
            edtApellido.setText("");
            edtEmail.setText("");
            edtUsuario.setText("");
            edtClave.setText("");

        }else{

            Toast.makeText(c, "Unsuccessful "+response, Toast.LENGTH_SHORT).show();

        }
    }

    private String send(){

        HttpURLConnection con = Conector.connect(urlAddress);

        if(con == null){

            return null;

        }

        try{

            OutputStream os = con.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

            bw.write(new DataPackager(nombre, apellido, email, usuario, clave).packData());

            bw.flush();
            bw.close();
            os.close();

            int responseCode = con.getResponseCode();

            if(responseCode == con.HTTP_OK){

                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

                StringBuffer response = new StringBuffer();

                String line;

                while((line = br.readLine()) != null){

                    response.append(line);

                }

                br.close();
                return response.toString();

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return null;

    }

}
