package com.example.ceplauncher.activities;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.ceplauncher.R;
import com.example.ceplauncher.utils.SharedPrefDarkMode;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity
{
    //METODO PARA CERRAR LA ACTIVIDAD A TRAVES DEL BOTÓN
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==android.R.id.home){

            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        //CREA UN OBJETO DE LA CLASE SharedPrefDarkMode
        //SI LLAMA AL METODO loadDarmode Y DEVUELVE TRUE, SETEA EL TEMA OSCURO
        //SINO SETEA EL MODO Light
        SharedPrefDarkMode sharedPrefDarkMode = new SharedPrefDarkMode(getApplicationContext());

        if(sharedPrefDarkMode.loadDarkMode())
        {
            setTheme(R.style.ModoOscuro);
        }
        else setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
    }
}

