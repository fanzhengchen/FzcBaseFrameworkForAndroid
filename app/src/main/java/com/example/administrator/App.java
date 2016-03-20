package com.example.administrator;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

/**
 * Created by Administrator on 2016/3/21.
 */
public class App extends Application {

    private static Context context = null;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getInstance() {
        return context;
    }
}
