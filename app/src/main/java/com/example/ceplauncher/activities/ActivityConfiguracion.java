package com.example.ceplauncher.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.example.ceplauncher.R;
import com.example.ceplauncher.utils.SharedPrefDarkMode;
import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class ActivityConfiguracion extends AppCompatActivity {

    Toolbar toolbarBasica;
    Switch switchDarkMode;
    SharedPrefDarkMode sharedPrefDarkMode;
    LinearLayout linearLayoutIdiomas, linearLayoutVincularCuenta;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sharedPrefDarkMode = new SharedPrefDarkMode(getApplicationContext());

        if(sharedPrefDarkMode.loadDarkMode())
        {
            setTheme(R.style.ModoOscuro);
        }
        else setTheme(R.style.AppTheme);

        //cargarIdiomaGuardado();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        linearLayoutIdiomas = (LinearLayout) findViewById(R.id.linearLayoutIdiomas);
        linearLayoutVincularCuenta = (LinearLayout) findViewById(R.id.linearLayoutVincularCuenta);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        toolbarBasica = (Toolbar) findViewById(R.id.toolbarBasica);
        setSupportActionBar(toolbarBasica);

        //Muestra el botón para ir atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        switchDarkMode = (Switch) findViewById(R.id.switchDarkMode);

        //SI AL LLAMAR AL METODO DEVUELVE TRUE, MANTIENE EL SWITCH EN CHECKED
        if(sharedPrefDarkMode.loadDarkMode())
        {
            switchDarkMode.setChecked(true);
        }
        switchDarkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {

                //SI EL USUARIO LO ACTIVA, SE LLAMA AL METODO setDarkMode Y SE LE PASA TRUE PARA
                //ACTIVAR EL MODO NOCHE
                if(isChecked)
                {
                    sharedPrefDarkMode.setDarkMode(true);
                    restartApp();
                }
                //SI LO "deschequea xxd" SE LE LLAMA AL METODO Y SE LE PASA FALSE
                //PARA DESACTIVAR EL MODO NOCHE
                else
                {
                    sharedPrefDarkMode.setDarkMode(false);
                    restartApp();
                }
            }
        });

        linearLayoutIdiomas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogIdiomas();
            }
        });

        linearLayoutVincularCuenta.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                //DECLARACIÓN DE UN ScnackBar CON COLOR DE TEXTO Y FONDO PERSONALIZADO
                Snackbar snackbar = Snackbar.make(coordinatorLayout, R.string.text_snackbar, Snackbar.LENGTH_LONG);
                snackbar.setActionTextColor(getResources().getColor(R.color.colorBlancoLetra));
                View snackbarView = snackbar.getView();
                snackbarView.setBackgroundColor(getColor(R.color.colorBotones));
                snackbarView.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                snackbar.show();
            }
        });

    }

    //HACE UN RELOAD DE LA ACTIVITY ACTUAL
    public void restartApp()
    {
        finish();
        startActivity(getIntent());
    }

    //LLAMA AL ACTIVITY MAIN LIMPIANDO EL STACK DE LAS Activities
    private void reloadActivityFlags()
    {
        Intent intent = new Intent(getApplicationContext(),
                ActivityTabItemsEntitat.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    //METODO PARA CERRAR LA ACTIVIDAD A TRAVES DEL BOTÓN
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId()==android.R.id.home){

            reloadActivityFlags();
        }
        return super.onOptionsItemSelected(item);
    }

    //METODO PARA FORZAR EL REINICIO DE LA ACTIVIDAD A TRAVES DEL BOTÓN ATRÁS DEL MOVIL
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        reloadActivityFlags();
    }

    //ShowDialog IDIOMAS
    private void showDialogIdiomas()
    {
        final String[] itemsIdiomas = {getString(R.string.idioma_esp), getString(R.string.idioma_cat), getString(R.string.idioma_ing)};
        AlertDialog.Builder builderAlertDialog = new AlertDialog.Builder(ActivityConfiguracion.this);
        builderAlertDialog.setTitle(getString(R.string.titulo_show_dialog_idiomas));
        builderAlertDialog.setSingleChoiceItems(itemsIdiomas, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int position) {
                switch (position)
                {
                    case 0:
                        setLocal("es");
                        reloadActivityFlags();
                        break;

                    case 1:
                        setLocal("ca");
                        reloadActivityFlags();
                        break;

                    case 2:
                        setLocal("en");
                        reloadActivityFlags();
                        break;

                    default:
                            dialogInterface.dismiss();
                }
            }
        });

        AlertDialog dialog = builderAlertDialog.create();
        dialog.show();
    }

    //CONFIGURA EL IDIOMA QUE ELIGE EL USUARIO
    private void setLocal(String idioma)
    {
        Locale locale = new Locale(idioma);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editorSP = getSharedPreferences("Idiomas", MODE_PRIVATE).edit();
        editorSP.putString("Mis_idiomas", idioma);
        editorSP.apply();
    }

    //CARAGA EL IDIOMA SLECCIONADO AL CERRAR LA APP (SIN USO)
    public void cargarIdiomaGuardado()
    {
        SharedPreferences sp = getSharedPreferences("Idiomas", Activity.MODE_PRIVATE);
        String idioma = sp.getString("Mis_idiomas", "");
        setLocal(idioma);
    }
}
