package com.example.vakulenko.notebook.contract;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;
import com.example.vakulenko.notebook.dao.AppDatabase;

public class CustomContext extends Application {

    public static final String APP_PREFERENCES = "app_preferences";

    private static AppDatabase db;

    private static SharedPreferences sp;

    private static Context instance;

    public CustomContext() {
        instance = this;
    }

    public static AppDatabase getDB() {
        if (db == null) {
            db = Room.databaseBuilder(instance,
                    AppDatabase.class, "database-notebook")
                    .allowMainThreadQueries()
                    .build();
        }
        return db;
    }

    public static SharedPreferences getSP() {
        if (sp == null) {
            sp = instance.getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        }
        return sp;
    }
}
