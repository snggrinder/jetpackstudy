package com.hb.jetpackstudy;

import android.app.Application;

public class MyApp extends Application {
    private static MyApp myApp;

    public MyApp() {
    }
    public static MyApp getInstance(){
        if (myApp == null){
            synchronized (MyApp.class){
                if (myApp ==null){}
                myApp = new MyApp();
            }
        }
        return myApp;
    }
}
