package com.dchavez.mod1class2_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.dchavez.adapters.ListaAdapter;
import com.dchavez.models.Objeto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvLista;
    private ArrayList<Objeto> lista= new ArrayList<Objeto>();
    private ListaAdapter adapter;
    private EditText txtUno,txtDos,txtTres,txtCuatro;
    private Button guardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLista = (ListView)findViewById(R.id.main_lst_lista);

        /*lista.add(new Objeto("Hola","a","todos",":)"));
        lista.add(new Objeto("Texto","a","todos","X)"));
        lista.add(new Objeto("Atención","a","todos",":O"));
        lista.add(new Objeto("Probando","a","todos",":|"));
        lista.add(new Objeto("Leyendo","a","todos",":D"));
        lista.add(new Objeto("Escribiendo","a","todos",":("));
        lista.add(new Objeto("Saludando","a","todos",":p"));*/

        adapter = new ListaAdapter(getApplicationContext(),lista);
        lvLista.setAdapter(adapter);

        txtUno = (EditText)findViewById(R.id.txtTextoUno);
        txtDos = (EditText)findViewById(R.id.txtTextoDos);
        txtTres = (EditText)findViewById(R.id.txtTextTres);
        txtCuatro = (EditText)findViewById(R.id.txtTextoCuatro);
        guardar = (Button)findViewById(R.id.btnGrabar);
        
    }

    @Override
    protected void onResume() {
        super.onResume();
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Uno = txtUno.getText().toString().trim();
                String Dos = txtDos.getText().toString().trim();
                String Tres = txtTres.getText().toString().trim();
                String Cuatro = txtCuatro.getText().toString().trim();

                /*Validamos que ingresado*/
                if (Uno.length() > 0 && Dos.length() > 0 && Tres.length() > 0 && Cuatro.length() > 0) {
                    lista.add(new Objeto(Uno,Dos,Tres,Cuatro,"http://staticf5a.lavozdelinterior.com.ar/sites/default/files/styles/box_120_120/public/nota_periodistica/28_Jul_2015_20_17_02_richd-android.jpg"));
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(getApplicationContext(),getResources().getString(R.string.validacion),Toast.LENGTH_SHORT).show();
                }

            }
        });
        lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Objeto item = lista.get(position);
                Toast.makeText(getApplicationContext(), item.getTextoUno() + " " + item.getTextoDos() + " " + item.getTextoTres() + " " + item.getTextoCuatro(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
