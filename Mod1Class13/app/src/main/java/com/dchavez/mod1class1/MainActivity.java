package com.dchavez.mod1class1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LifeCycle", "on-create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "on-start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle", "on-restart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "on-stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "on-destroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "on-pause");
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
