package com.jchavez.mod2class6;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jchavez.mod2class6.utils.GPSTracker;

public class MainActivity extends AppCompatActivity {
    private LocationListener locationListener;
    private LocationManager locationManager;
    private Button btnObtener;
    private EditText txtLatitud, txtLongitud;
    private GPSTracker gpsTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLatitud = (EditText) findViewById(R.id.txtLatitud);
        txtLongitud = (EditText) findViewById(R.id.txtLongitud);
        btnObtener = (Button) findViewById(R.id.btnObtener);
        gpsTracker = new GPSTracker(MainActivity.this);
       /*
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if ((ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) &&
                (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        */

    }

    public void onResume() {
        super.onResume();
        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location location = gpsTracker.getLocation();

                if (gpsTracker.canGetLocation()){
                    txtLatitud.setText(String.valueOf(location.getLatitude()));
                    txtLongitud.setText(String.valueOf(location.getLongitude()));
                }
                else
                {
                    gpsTracker.showSettingsAlert();
                }

            }
        });
    }


}
