package com.dchavez.mod1class3_1;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by alumno on 11/14/15.
 */
public class SegundoActivity extends AppCompatActivity {

    private SimpleDraweeView ivImagen;
    private TextView lblTitulo,lblSubtitulo,lblTextoUno,lblTextoDos,lblPrecioUno,lblPrecioDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
        Bundle bundle = getIntent().getExtras();

        ivImagen = (SimpleDraweeView)findViewById(R.id.sgd_iv_imagen);

        lblTitulo = (TextView)findViewById(R.id.sgd_lblTitulo);
        lblSubtitulo = (TextView)findViewById(R.id.sgd_lblSubtitulo);
        lblTextoUno = (TextView)findViewById(R.id.sgd_lblTextoUno);
        lblTextoDos = (TextView)findViewById(R.id.sgd_lblTextoDos);
        lblPrecioUno = (TextView)findViewById(R.id.sgd_lblPrecioUno);
        lblPrecioDos = (TextView)findViewById(R.id.sgd_lblPrecioDos);


        if(bundle.containsKey("titulo")){
            String titulo = bundle.getString("titulo");
            lblTitulo.setText(titulo);
        }
        if(bundle.containsKey("subtitulo")){
            String subtitulo = bundle.getString("subtitulo");
            lblSubtitulo.setText(subtitulo);
        }
        if(bundle.containsKey("textoUno")){
            String textoUno = bundle.getString("textoUno");
            lblTextoUno.setText(textoUno);
        }
        if(bundle.containsKey("textoDos")){
            String textoDos = bundle.getString("textoDos");
            lblTextoDos.setText(textoDos);
        }
        if(bundle.containsKey("precioUno")){
            String precioUno = bundle.getString("precioUno");
            lblPrecioUno.setText(precioUno);
        }
        if(bundle.containsKey("precioDos")){
            String precioDos = bundle.getString("precioDos");
            lblPrecioDos.setText(precioDos);
        }
        if(bundle.containsKey("uri")){
            String url= bundle.getString("uri");
            Log.d("url",url);
            ivImagen.setImageURI(Uri.parse(url));
        }
    }
}
