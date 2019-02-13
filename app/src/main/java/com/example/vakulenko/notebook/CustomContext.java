package com.example.vakulenko.notebook;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import com.example.vakulenko.notebook.dao.AppDatabase;

public class CustomContext extends Application {

    private static AppDatabase db;

    private static Context instance;

    public CustomContext() {
        instance = this;
    }

    public static AppDatabase getDB() {
        if (db == null) {
            return Room.databaseBuilder(instance,
                    AppDatabase.class, "database-notebook")
                    .allowMainThreadQueries()
                    .build();
        }
        return db;
    }
}
