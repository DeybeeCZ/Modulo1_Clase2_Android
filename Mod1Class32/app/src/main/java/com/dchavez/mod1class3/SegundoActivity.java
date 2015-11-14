package com.dchavez.mod1class3;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.dchavez.adapters.ListaAdapter;
import com.dchavez.utils.Constantes;

/**
 * Created by alumno on 11/14/15.
 */
public class SegundoActivity extends AppCompatActivity {

    private ListView lvLista;
    private ListaAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        lvLista = (ListView)findViewById(R.id.sgdo_lst_Lista);
        adapter = new ListaAdapter(getApplicationContext(), Constantes.lista);
        lvLista.setAdapter(adapter);
    }
}
