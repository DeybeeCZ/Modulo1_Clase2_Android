package com.dchavez.mod1_class2;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by alumno on 11/7/15.
 */
public class SegundoActivity extends AppCompatActivity{

    private TextView usuario;
    private Button atras;
    private Button siguiente;
    private String txt_usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        usuario = (TextView)findViewById(R.id.lblTexto);
        atras = (Button)findViewById(R.id.btn_atras);
        siguiente = (Button)findViewById(R.id.btn_siguiente);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(getIntent().hasExtra("usuario")){
            txt_usuario = getIntent().getStringExtra("usuario");
            usuario.setText(Html.fromHtml("Bienvenido <br/>"+txt_usuario));
        }

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundoActivity.this,TerceroActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("usuario",txt_usuario);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
