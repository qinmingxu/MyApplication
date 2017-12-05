package com.example.day07;

import android.app.Application;

/**
 * Created by wan on 2017/12/5.
 */

public class CrashApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init(getBaseContext());
    }
}
