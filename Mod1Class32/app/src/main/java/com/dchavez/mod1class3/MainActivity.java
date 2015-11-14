package com.dchavez.mod1class3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.dchavez.models.Direcciones;
import com.dchavez.utils.Constantes;

public class MainActivity extends AppCompatActivity {

    private Spinner spnDistritos;
    private EditText edDireccion,edNombre;
    private Button btnGrabar,btnListar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spnDistritos = (Spinner)findViewById(R.id.main_spr_distrito);
        edDireccion = (EditText)findViewById(R.id.main_txt_direccion);
        edNombre = (EditText)findViewById(R.id.main_txt_nombre);
        btnGrabar = (Button)findViewById(R.id.main_btn_grabar);
        btnListar = (Button)findViewById(R.id.main_btn_listar);
    }

    @Override
    protected void onResume() {
        super.onResume();


        btnGrabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoDistrito = spnDistritos.getSelectedItem().toString();
                String textoDireccion = edDireccion.getText().toString();
                String textNombre = edNombre.getText().toString();
                Direcciones item= new Direcciones();
                item.setDistrito(textoDistrito);
                item.setDireccion(textoDireccion);
                item.setNombre(textNombre);
                Constantes.lista.add(item);

            }
        });

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,SegundoActivity.class);
                startActivity(intent);
            }
        });
    }
}
