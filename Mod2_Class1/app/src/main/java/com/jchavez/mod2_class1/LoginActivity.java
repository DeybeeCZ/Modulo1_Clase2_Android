package com.jchavez.mod2_class1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import aplicacion.Configuracion;
import models.Usuario;

public class LoginActivity extends AppCompatActivity {
    private EditText txtCorreo, txtContrasenia;
    private Button btnLogin;
    private LinearLayout llRegistrarse;
    private CheckBox cbRecordar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Configuracion.sentencias.verificarSesion()){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }

        setContentView(R.layout.activity_login);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtContrasenia = (EditText) findViewById(R.id.txtContrasenia);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        llRegistrarse = (LinearLayout) findViewById(R.id.llRegistrarse);
        cbRecordar = (CheckBox) findViewById(R.id.cbRecordarContrasenia);
    }

    @Override
    protected void onResume() {
        super.onResume();
        llRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistroActivity.class);
                startActivity(intent);

            }
        });

        btnLogin.setOnClickListener( new View.OnClickListener(){
                                         @Override
                                         public void onClick(View v) {
                                             if (!txtCorreo.getText().toString().trim().equals("")
                                                     && !txtContrasenia.getText().toString().trim().equals("")){
                                                 Usuario usuario = new Usuario();
                                                 usuario.setCorreo(txtCorreo.getText().toString());
                                                 usuario.setContrasenia(txtContrasenia.getText().toString());
                                                 Usuario resultado = Configuracion.sentencias.obtenerUsuario(usuario);
                                                 if (resultado !=null){


                                                     Toast.makeText(getApplicationContext(), "Login correcto", Toast.LENGTH_SHORT).show();
                                                     Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                                                     if (cbRecordar.isChecked())
                                                         Configuracion.sentencias.registrarSesion(usuario.getCorreo());
                                                     else
                                                        intent.putExtra("correo",usuario.getCorreo());

                                                     intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                     intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                                     intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                                     startActivity(intent);
                                                     finish();
                                                 }
                                             }else{
                                                 Toast.makeText(getApplicationContext(), "Ingrese todos los datos", Toast.LENGTH_SHORT).show();
                                             }
                                         }
                                     }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
