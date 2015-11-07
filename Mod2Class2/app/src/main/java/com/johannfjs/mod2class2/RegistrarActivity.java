package com.johannfjs.mod2class2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.johannfjs.aplication.Configuracion;
import com.johannfjs.models.Articulo;
import com.johannfjs.sliding.BaseActivity;


public class RegistrarActivity extends BaseActivity {

    private EditText txtTitulo;
    private EditText txtDescripcion;
    private Spinner spCategoria;
    private Button btnRegistrar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        txtTitulo = (EditText) findViewById(R.id.editText_titulo);
        txtDescripcion = (EditText) findViewById(R.id.editText_descripcion);
        spCategoria = (Spinner) findViewById(R.id.spCategoria);
        btnRegistrar = (Button) findViewById(R.id.btnRegistrar);

    }

    @Override
    public void onResume(){
        super.onResume();
        btnRegistrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (txtTitulo.getText().toString().equals("")){
                    txtTitulo.setError("Ingrese Titulo");
                } else if (txtDescripcion.getText().toString().equals("")){
                    txtDescripcion.setError("Ingrese Descripcion");
                } else if (!txtTitulo.getText().toString().equals("")
                        &&!txtDescripcion.getText().toString().equals("")){
                    Articulo item = new Articulo(
                            txtTitulo.getText().toString(),
                            txtDescripcion.getText().toString(),
                            spCategoria.getSelectedItem().toString()
                    );
                    Configuracion.querysSQL.insertarArticulos(item);
                    Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"Ingrese todos los datos requeridos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


}
