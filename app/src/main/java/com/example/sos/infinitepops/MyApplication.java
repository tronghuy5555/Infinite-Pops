package com.example.sos.infinitepops;

import android.app.Application;
import android.content.Context;

/**
 * MyApplication
 *
 * @author SOS
 * @since 08/09/2018.
 */
public class MyApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}
