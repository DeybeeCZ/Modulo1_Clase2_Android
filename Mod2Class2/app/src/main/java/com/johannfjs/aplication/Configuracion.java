package com.johannfjs.aplication;

import android.app.Application;

import com.johannfjs.sqlite.QuerysSQL;

/**
 * Created by alumno on 10/21/15.
 */
public class Configuracion extends Application {
    public static QuerysSQL querysSQL;

    @Override
    public void onCreate() {
        super.onCreate();
        querysSQL = new QuerysSQL(getApplicationContext());
    }
}
