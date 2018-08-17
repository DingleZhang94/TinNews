package com.dingle.tinnews;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.dingle.tinnews.database.AppDatabase;
import com.facebook.stetho.Stetho;

public class TinApplication extends Application {
    public static AppDatabase database;
    @Override

    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        //7.7 Init the Room in the TinApplication
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "tin_db").build();
    }

    //7.7 Init the Room in the TinApplication
    public static AppDatabase getDataBase() {
        return database;
    }


}
