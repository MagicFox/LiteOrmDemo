package com.fox.db.common;

import android.app.Application;

/**
 * Created by magicfox on 2017/7/25.
 */

public class CommonApplication extends Application {
    static CommonApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }


    public static CommonApplication getInstance(){
        return instance;
    }
}