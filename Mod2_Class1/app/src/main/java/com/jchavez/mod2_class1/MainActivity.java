package com.jchavez.mod2_class1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import aplicacion.Configuracion;

public class MainActivity extends AppCompatActivity {
    private TextView lblTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lblTexto = (TextView) findViewById(R.id.lblTexto);

        String correo="";
        if (Configuracion.sentencias.verificarSesion()){
            correo = Configuracion.sentencias.obtenerCorreoSesion();
        }
        else{
            correo = getIntent().getStringExtra("correo");
        }

        String nombre = Configuracion.sentencias.obtenerNombreUsuarioLogueado(correo);
        Log.d("nombre", nombre);
        lblTexto.setText("Bienvenido\n "+ nombre);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
