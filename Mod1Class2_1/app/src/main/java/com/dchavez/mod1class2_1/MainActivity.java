package com.dchavez.mod1class2_1;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
    private String Uno,Dos,Tres,Cuatro;


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
        guardar.setTag(-1);

    }

    @Override
    protected void onResume() {
        super.onResume();
        guardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int valor = (int) guardar.getTag();
                Uno = txtUno.getText().toString().trim();
                Dos = txtDos.getText().toString().trim();
                Tres = txtTres.getText().toString().trim();
                Cuatro = txtCuatro.getText().toString().trim();
                if (valor == -1) {
                /*Validamos que ingresado*/
                    if (Uno.length() > 0 && Dos.length() > 0 && Tres.length() > 0 && Cuatro.length() > 0) {
                        lista.add(new Objeto(Uno, Dos, Tres, Cuatro, "http://staticf5a.lavozdelinterior.com.ar/sites/default/files/styles/box_120_120/public/nota_periodistica/28_Jul_2015_20_17_02_richd-android.jpg"));
                        adapter.notifyDataSetChanged();

                    } else {
                        Toast.makeText(getApplicationContext(), getResources().getString(R.string.validacion), Toast.LENGTH_SHORT).show();
                    }

                } else {
                    lista.get(valor).setTextoUno(Uno);
                    lista.get(valor).setTextoDos(Dos);
                    lista.get(valor).setTextoTres(Tres);
                    lista.get(valor).setTextoCuatro(Cuatro);
                    guardar.setTag(-1);
                }
                txtUno.setText("");
                txtDos.setText("");
                txtTres.setText("");
                txtCuatro.setText("");
                adapter.notifyDataSetChanged();
            }

        });

            lvLista.setOnItemClickListener(new AdapterView.OnItemClickListener()

            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setTitle("Mensaje");
                    alertDialog.setMessage("Seleccione una opcion");
                    alertDialog.setPositiveButton("Modificar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Objeto item = lista.get(position);
                            //Toast.makeText(getApplicationContext(), item.getTextoUno() + " " + item.getTextoDos() + " " + item.getTextoTres() + " " + item.getTextoCuatro(), Toast.LENGTH_SHORT).show();
                            txtUno.setText(item.getTextoUno());
                            txtDos.setText(item.getTextoDos());
                            txtTres.setText(item.getTextoTres());
                            txtCuatro.setText(item.getTextoCuatro());
                            guardar.setTag(position);
                        }
                    });

                    alertDialog.setNegativeButton("Eliminar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            lista.remove(position);
                            txtUno.setText("");
                            txtDos.setText("");
                            txtTres.setText("");
                            txtCuatro.setText("");
                            adapter.notifyDataSetChanged();
                        }
                    });
                    alertDialog.setNeutralButton("Neutro", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    alertDialog.show();


                }
            });

    }
}
