package mod1_class6.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import adapters.ListaAdapter;
import models.Imagenes;

public class MainActivity extends AppCompatActivity {

    private ListView lvlista;
    private ListaAdapter adapter;
    private ArrayList<Imagenes> lista = new ArrayList<Imagenes>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvlista = (ListView) findViewById(R.id.lvLista);


        for (int i=1; i<=100; i++){
            lista.add(new Imagenes(
                    "http://johannfjs.com/android/images/HDPackSuperiorWallpapers424_0"+(i<10? ("0" + i) : i)+".jpg",
                    "Imagen"+i,
                    "la clase de android - la clase de android -la clase de android -la clase de android -la clase de android -la clase de android -",
                     "12/02/2015", i));
        }
        adapter = new ListaAdapter(MainActivity.this, lista);
        lvlista.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
