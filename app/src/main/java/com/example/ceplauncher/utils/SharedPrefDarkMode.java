package com.example.ceplauncher.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefDarkMode {
    SharedPreferences sp;

    public SharedPrefDarkMode(Context context) {
        sp = context.getSharedPreferences("filename", context.MODE_PRIVATE);
    }

    //GUARDA UN boolean DEL ESTAOD DEL MODO OSCURO
    public void setDarkMode(Boolean estado)
    {
        SharedPreferences.Editor spEdtior = sp.edit();
        spEdtior.putBoolean("ModoOscuro", estado);
        spEdtior.apply();
    }

    //DEVUELVE EL ESTADO DEL MODO OSCURO
    public Boolean loadDarkMode()
    {
        Boolean estado = sp.getBoolean("ModoOscuro", false);
        return estado;
    }
}
