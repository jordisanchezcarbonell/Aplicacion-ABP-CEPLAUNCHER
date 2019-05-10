package com.example.ceplauncher.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.ceplauncher.R;

public class ActivitySplash extends AppCompatActivity {


    private final static int SPLASH_TIME_OUT = 900;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /*if (!isTaskRoot()) {

            finish();
            return;
        }*/

        //Esconde la StatusBar del movil
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //MetodosVarios.abrirActivity(getApplicationContext(), ActivityIniciarSesion.class);
                startActivity(new Intent(getApplicationContext(), ActivityIniciarSesion.class));
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
