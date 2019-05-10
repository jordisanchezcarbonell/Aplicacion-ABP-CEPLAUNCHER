package com.example.ceplauncher.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.ceplauncher.R;
import com.example.ceplauncher.utils.LoginManager;

import androidx.appcompat.widget.Toolbar;

public class ActivityMainUser extends BaseActivity {

    TextView textViewWelcomeUser;
    Button buttonCerrarSesion, buttonsnackbar;
    Toolbar toolbarPersonalizada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);

        toolbarPersonalizada = (Toolbar) findViewById(R.id.toolbarPersonalizada);
        setSupportActionBar(toolbarPersonalizada);

        textViewWelcomeUser = (TextView) findViewById(R.id.textViewWelcomeUser);
        buttonCerrarSesion = (Button) findViewById(R.id.buttonCerrarSesion);

        String emailUserGuardado = LoginManager.getEmail(getApplicationContext());
        textViewWelcomeUser.setText(getString(R.string.mensaje_bienvenida) + emailUserGuardado);

        buttonCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogoCerrarSesion();
            }
        });

    }


    //LLAMA AL ACTIVITY MAIN LIMPIANDO EL STACK DE LAS Activities
    public void restartApp()
    {
        Intent intent = new Intent(getApplicationContext(),
                ActivityTabItemsEntitat.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void dialogoCerrarSesion()
    {
        final Dialog  dialogCerrarSesion = new Dialog(ActivityMainUser.this);
        dialogCerrarSesion.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogCerrarSesion.setContentView(R.layout.custom_dialog_logout);

        Button dialogButtonCancel = (Button) dialogCerrarSesion.findViewById(R.id.buttonCancelDialogLogOut);
        Button dialogButtonOk = (Button) dialogCerrarSesion.findViewById(R.id.buttonOkDialogLogOut);

        dialogButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.guardarEmail("", getApplicationContext());
                LoginManager.guardarPassword("", getApplicationContext());
                Intent intent = new Intent(getApplicationContext(),
                        ActivityIniciarSesion.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogCerrarSesion.dismiss();
            }
        });
        dialogCerrarSesion.show();
    }

    //INFLA LA TOOLBAR CON LOS ICONOS
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.iconos_toolbar_activity_user, menu);
        return true;
    }

    //METODO PARA ESCRIBIR QUE SE HARÁ EN CADA EVENTO CLIC DEL ICONO
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.itemIconoHome:
                restartApp();
                break;
            case R.id.itemOptions:
                startActivity(new Intent(getApplicationContext(), ActivityConfiguracion.class));
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
