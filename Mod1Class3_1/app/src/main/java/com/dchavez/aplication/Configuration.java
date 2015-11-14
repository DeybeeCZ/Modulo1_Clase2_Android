package com.dchavez.aplication;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by alumno on 11/14/15.
 */
public class Configuration extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(getApplicationContext());
    }
}
