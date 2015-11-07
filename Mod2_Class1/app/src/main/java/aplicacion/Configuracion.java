package aplicacion;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import models.Usuario;
import sqlite.SentenciasSQL;

/**
 * Created by alumno on 10/14/15.
 */
public class Configuracion extends Application{
    public static SentenciasSQL sentencias;

    @Override
    public void onCreate(){
        super.onCreate();
        sentencias = new SentenciasSQL(getApplicationContext());
    }



}
