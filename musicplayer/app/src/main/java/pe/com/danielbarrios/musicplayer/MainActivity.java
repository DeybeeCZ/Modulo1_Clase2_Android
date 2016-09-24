package pe.com.danielbarrios.musicplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_principal_mi_musica).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_principal_mi_musica:
                dirigirActivityMiMusica();
                break;





        }
    }

    public void dirigirActivityMiMusica(){
        startActivity(new Intent(MainActivity.this,ListaMusicaActivity.class));
    }
}
