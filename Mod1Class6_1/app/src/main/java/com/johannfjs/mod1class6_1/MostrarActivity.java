package com.johannfjs.mod1class6_1;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.johannfjs.models.Cupon;
import com.nostra13.universalimageloader.core.ImageLoader;

import utils.Constantes;

public class MostrarActivity extends AppCompatActivity {
    protected ImageLoader imageLoader = ImageLoader.getInstance();
    private ImageView ivImagen;
    private TextView lblTitulo;
    private TextView lblSubtitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);
        ivImagen = (ImageView) findViewById(R.id.ivImagen);
        lblTitulo = (TextView) findViewById(R.id.lblTitulo);
        lblSubtitulo = (TextView) findViewById(R.id.lblSubtitulo);

        if (getIntent().hasExtra("position")){
            int posicion = getIntent().getIntExtra("position", );
            Cupon item = Constantes.lista.get(posicion);
            imageLoader.displayImage(item.getRutaImagen(),);
            lblTitulo.setText(item.getTitulo());
            lblSubtitulo.setText(item.getSubtitulo());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mostrar, menu);
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
