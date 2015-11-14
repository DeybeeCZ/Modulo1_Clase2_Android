package com.dchavez.mod1class3_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.dchavez.adapters.GrillaAdapter;
import com.dchavez.models.Cupon;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private GridView gvGrilla;
    private GrillaAdapter adapter;
    private ArrayList<Cupon> lista = new ArrayList<Cupon>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gvGrilla = (GridView)findViewById(R.id.main_gv_grilla);

        for (int i=10; i<30;i++){
            Cupon item = new Cupon();
            item.setTitulo("Titulo "+i);
            item.setSubtitulo("Subtitulo " + i);
            item.setTextoUno("Texto uno " + i);
            item.setTextoDos("Texto dos " + i);
            item.setPrecioUno("precio uno " + i);
            item.setPrecioDos("precio dos " + i);
            item.setRutaimagen("http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_0"+i+".jpg");
            lista.add(item);
        }
        adapter = new GrillaAdapter(getApplicationContext(),lista);
        gvGrilla.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gvGrilla.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,SegundoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("titulo",lista.get(position).getTitulo());
                bundle.putString("subtitulo",lista.get(position).getSubtitulo());
                bundle.putString("textoUno",lista.get(position).getTextoUno());
                bundle.putString("textoDos",lista.get(position).getTextoDos());
                bundle.putString("precioUno",lista.get(position).getPrecioUno());
                bundle.putString("precioDos",lista.get(position).getPrecioDos());
                bundle.putString("uri",lista.get(position).getRutaimagen());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
