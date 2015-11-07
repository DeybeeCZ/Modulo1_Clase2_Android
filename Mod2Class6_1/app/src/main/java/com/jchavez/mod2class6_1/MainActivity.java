package com.jchavez.mod2class6_1;

import android.content.Context;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private Button btnObtener;
    private TextView txtContenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnObtener = (Button) findViewById(R.id.btnObtener);
        txtContenido = (TextView) findViewById(R.id.txtContenido);
    }

    @Override
    protected void onResume(){
        super.onResume();
        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contenido = "";
                contenido+= "SDK->"+ Build.VERSION.SDK + "\n";
                contenido+= "Modelo->"+Build.MODEL + "\n";
                contenido+="Device->"+Build.DEVICE + "\n";
                contenido+="Host->"+Build.HOST + "\n";
                contenido+="Id->"+Build.ID + "\n";

                TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                contenido += "IMEI->"+telephonyManager.getDeviceId() + "\n";
                txtContenido.setText(contenido);
            }
        });
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
