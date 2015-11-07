package com.dchavez.mod1class1_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner spin;
    private EditText precio;
    private Button procesar;
    private TextView respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin = (Spinner)findViewById(R.id.spDatos);
        precio = (EditText) findViewById(R.id.txtPrecio);
        procesar = (Button) findViewById(R.id.btnProcesar);
        respuesta = (TextView) findViewById(R.id.txtRespuesta);

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this
                ,android.R.layout.simple_spinner_dropdown_item
                ,getResources().getStringArray(R.array.data));

        spin.setAdapter(arrayAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        procesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String seleccion = spin.getSelectedItem().toString();
                String precioTexto = precio.getText().toString();
                respuesta.append(Html.fromHtml("El precio de " + seleccion + " es :" + precioTexto + "<br/>"));
            }
        });

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0){
                    String dato=spin.getSelectedItem().toString();
                    respuesta.setText(dato);
                }else{
                    respuesta.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
