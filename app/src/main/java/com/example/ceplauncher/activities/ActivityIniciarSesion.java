package com.example.ceplauncher.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ceplauncher.R;
import com.example.ceplauncher.utils.LoginManager;
import com.google.android.material.textfield.TextInputLayout;

public class ActivityIniciarSesion extends BaseActivity {

    EditText editTextEmail, editTextContraseña;
    TextInputLayout textInputLayoutEmail, textInputLayoutContraseña;
    Button buttonIniciarSesion;
    TextView textViewButtonRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inciar_sesion);

        //Esconde la StatusBar del movil
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        if(!LoginManager.getEmail(getApplicationContext()).equals(""))
        {
            startActivity(new Intent(getApplicationContext(), ActivityTabItemsEntitat.class));
            finish();
        }

        //Setear variables
        editTextContraseña = (EditText) findViewById(R.id.editTextContraseña);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.textImputLayoutEmail);
        textInputLayoutContraseña = (TextInputLayout) findViewById(R.id.textImputLayoutContraseña);
        buttonIniciarSesion = (Button) findViewById(R.id.buttonIniciarSesion);
        textViewButtonRegistro = (TextView) findViewById(R.id.textViewButtonRegistro);

        buttonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validacionEmailContraseña())
                {
                    Intent intent = new Intent(getApplicationContext(), ActivityTabItemsEntitat.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        textViewButtonRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ActivityRegistro.class));
            }
        });
    }

    protected boolean validacionEmailContraseña()
    {
        View focusViewEmail = editTextEmail;
        View focusViewPass = editTextContraseña;
        boolean validacionCorrecta = false;

        textInputLayoutEmail.setError(null);
        textInputLayoutContraseña.setError(null);


        //Extrae el texto de los editText para hacer comprobaciones
        String email = editTextEmail.getText().toString();
        String contraseña = editTextContraseña.getText().toString();

        //Comprobación del email con la Base de Datos...
        if(TextUtils.isEmpty(email))
        {
            textInputLayoutEmail.setError(getString(R.string.intro_email));
            focusViewEmail.requestFocus();
        }
        else if(!email.equals("123@hotmail.com"))
        {
            textInputLayoutEmail.setError(getString(R.string.email_incorrecto));
            focusViewEmail.requestFocus();
        }
        else if(email.equals("123@hotmail.com"))
        {
            if(contraseña.isEmpty())
            {
                textInputLayoutContraseña.setError(getString(R.string.pass_incorrecta));
                focusViewPass.requestFocus();
            }
            else
            {
                //Cmprobación contraseña base de datos
                LoginManager.guardarEmail(email, getApplicationContext());
                LoginManager.guardarPassword(contraseña, getApplicationContext());
                validacionCorrecta = true;
            }
        }
        return validacionCorrecta;
    }

}
