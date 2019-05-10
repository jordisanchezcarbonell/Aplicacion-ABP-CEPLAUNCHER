package com.example.ceplauncher.activities;

import android.os.Bundle;

import com.example.ceplauncher.R;

import androidx.appcompat.widget.Toolbar;

public class ActivityRegistro extends BaseActivity {

    Toolbar toolbarBasica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registro);

        toolbarBasica = (Toolbar) findViewById(R.id.toolbarBasica);
        setSupportActionBar(toolbarBasica);

        //Muestra el botón para ir atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
