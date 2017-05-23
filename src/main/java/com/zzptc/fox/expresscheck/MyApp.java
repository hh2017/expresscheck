package com.zzptc.fox.expresscheck;

import android.app.Application;

/**
 * Created by wanderders on 2016/10/23.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init();
    }
}
