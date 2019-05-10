package com.example.ceplauncher.utils;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;

public class MetodosVarios extends AppCompatActivity {


    public static void mostrarToast(Context context, String mensaje)
    {
        Toast t1 = Toast.makeText(context.getApplicationContext(), mensaje, Toast.LENGTH_SHORT);
        t1.show();
    }
}
