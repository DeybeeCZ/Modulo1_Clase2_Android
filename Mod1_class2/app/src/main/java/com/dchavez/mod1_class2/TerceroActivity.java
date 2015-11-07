package com.dchavez.mod1_class2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by alumno on 11/7/15.
 */
public class TerceroActivity extends AppCompatActivity {

    private TextView resultado;
    private Button salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercero);

        resultado = (TextView)findViewById(R.id.lblUser);
        salir = (Button)findViewById(R.id.btnSalir);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(getIntent().getExtras()!=null){
            if(getIntent().getExtras().containsKey("usuario")){
                String txt_usuario = getIntent().getExtras().getString("usuario");
                resultado.setText(txt_usuario);
            }
        }

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TerceroActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
