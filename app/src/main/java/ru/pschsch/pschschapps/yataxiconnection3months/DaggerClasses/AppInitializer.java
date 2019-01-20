package ru.pschsch.pschschapps.yataxiconnection3months.DaggerClasses;

import android.app.Application;

public class AppInitializer extends Application {
    private static AppComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.create();
    }
    public static AppComponent getComponent(){
        return component;
    }
}
