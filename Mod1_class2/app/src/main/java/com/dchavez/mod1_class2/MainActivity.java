package com.dchavez.mod1_class2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText user;
    private EditText pass;
    private Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText)findViewById(R.id.txtUser);
        pass = (EditText)findViewById(R.id.txtPassword);
        enter = (Button)findViewById(R.id.btnEnter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text_user = user.getText().toString().trim();
                String text_pass = pass.getText().toString().trim();
                if(text_user.length()>0 && text_pass.length()>0){
                    Intent intent = new Intent(MainActivity.this,SegundoActivity.class);
                    intent.putExtra("usuario",text_user);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),
                            getResources().getString(R.string.mensaje_validacion),
                            Toast.LENGTH_SHORT).show();
                }
                //

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
