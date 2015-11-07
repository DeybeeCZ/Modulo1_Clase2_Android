package com.jchavez.mod2_class1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import aplicacion.Configuracion;
import models.Usuario;

public class RegistroActivity extends AppCompatActivity {
    private EditText txtNombre, txtCorreo, txtContrasenia;
    private Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtCorreo = (EditText) findViewById(R.id.txtCorreoReg);
        txtContrasenia = (EditText) findViewById(R.id.txtContraseniaReg);
        btnRegistro = (Button) findViewById(R.id.btnRegistro);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!txtNombre.getText().toString().trim().equals("")
                        && !txtCorreo.getText().toString().trim().equals("")
                        && !txtContrasenia.getText().toString().trim().equals("")){
                    Usuario usuario = new Usuario();
                    usuario.setNombre(txtNombre.getText().toString());
                    usuario.setCorreo(txtCorreo.getText().toString());
                    usuario.setContrasenia(txtContrasenia.getText().toString());
                    Configuracion.sentencias.registrarUsuario(usuario);
                    Toast.makeText(getApplicationContext(),"Usuario creado", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro, menu);
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
