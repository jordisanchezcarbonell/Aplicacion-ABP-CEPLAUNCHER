package com.example.ceplauncher.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;

public class LoginManager {

    public LoginManager() {
    }

    //ALMACENA EL EMAIL EN SharedPreferences
    public static boolean guardarEmail(String email, Context context)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor spEditor = sp.edit();
        spEditor.putString(Constantes.KEY_EMAIL, email);
        spEditor.apply();
        return true;
    }

    //RECUPERA EL email de SharedPreferences a traves de su KEY
    public static String getEmail(Context context)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        String email = sp.getString(Constantes.KEY_EMAIL, "");
        return email;
    }

    public static boolean guardarPassword(String password, Context context)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor spEditor = sp.edit();
        spEditor.putString(Constantes.KEY_PASSWORD, password);
        spEditor.apply();
        return true;
    }

    public static String getPassword(Context context)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        String password = sp.getString(Constantes.KEY_PASSWORD, "");
        return password;
    }
}
