package com.apprendo.apprendodemo1;

import android.app.Application;

public class Globales extends Application {

    private int perfilUsuario;

    public int getPerfil(){
        return perfilUsuario;
    }

    public void setPerfil(int i){
        perfilUsuario=i;
    }
}
