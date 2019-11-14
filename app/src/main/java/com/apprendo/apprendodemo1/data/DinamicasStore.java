package com.apprendo.apprendodemo1.data;

import android.content.Context;
import android.content.res.AssetManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class DinamicasStore {

    public ArrayList<Dinamica> listado;
    public Context localContext;

    public DinamicasStore(Context c){
        listado = new ArrayList<>();
        localContext = c;
    }

    public ArrayList<Dinamica> cargarDinamicas(){
        JSONObject archivo=null;
        try {
            archivo = new JSONObject(loadJSONFromAsset());
            JSONArray arrActividades = archivo.getJSONArray("actividades");
            for(int i=0;i<arrActividades.length();i++) {
                listado.add(new Dinamica((JSONObject)arrActividades.get(i)));
            }
        }catch(JSONException e){
            System.out.println("Error en parsear el json");
        }
        return listado;
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            AssetManager am = localContext.getAssets();
            InputStream is = am.open("dataActividades.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
