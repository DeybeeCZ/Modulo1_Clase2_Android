package com.dchavez.mod1class1_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private Button procesar;
    private Button html;
    private TextView resultado;
    private Button mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText)findViewById(R.id.txtTexto);
        procesar = (Button)findViewById(R.id.btnEjecutar);
        mostrar = (Button)findViewById(R.id.btnMostrar);
        html = (Button)findViewById(R.id.btnHtml);
        resultado = (TextView)findViewById(R.id.lblResultado);
    }

    @Override
    protected void onResume() {
        super.onResume();
        procesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombreTexto = nombre.getText().toString();
                resultado.setText(nombreTexto);
            }
        });
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombreTexto=nombre.getText().toString();
                //Toast.makeText(getApplicationContext(),nombreTexto,Toast.LENGTH_SHORT).show();
                Toast toast = Toast.makeText(getApplicationContext(), nombreTexto, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        });

        html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombreTexto=nombre.getText().toString();
                resultado.setText(Html.fromHtml(nombreTexto));
            }
        });
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
