package com.joanachavez.mod1class3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnEjecutar;
    private EditText txtNombre;
    private LinearLayout llMostrar;
    private LinearLayout llOcultar;
    private LinearLayout llFormulario;
    private Spinner spBebidas;
    private Button btnMostrar;
    private TextView lblTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llMostrar = (LinearLayout) findViewById(R.id.llMostrar);
        llOcultar = (LinearLayout) findViewById(R.id.llOcultar);
        llFormulario = (LinearLayout) findViewById(R.id.llFormulario);
        txtNombre = (EditText) findViewById(R.id.txtNombre);
        btnEjecutar = (Button) findViewById(R.id.btnEjecutar);
        spBebidas = (Spinner) findViewById(R.id.spBebidas);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.bebidas));
        spBebidas.setAdapter(adapter);

    }
    @Override
    protected void onResume(){
        super.onResume();
        llMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llFormulario.setVisibility(View.VISIBLE);
            }
        });
        llOcultar.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                llFormulario.setVisibility(View.GONE);
            }
        });

        btnMostrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (spBebidas.getSelectedItemPosition() >0){
                    String texto = spBebidas.getSelectedItem().toString();
                    Toast t = Toast.makeText(MainActivity.this, texto, Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER | Gravity.RIGHT, 0, 0);
                    t.show();
                }
            }
        });

        spBebidas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position>0){
                    String texto = spBebidas.getSelectedItem().toString();
                    lblTexto.setText(texto);
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
