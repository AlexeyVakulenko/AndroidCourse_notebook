package com.example.vakulenko.notebook.entitys;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String text;

    public Note(String text) {
        this.text = text;
    }

    @Ignore
    public Note(int id, String text) {
        this.id = id;
        this.text = text;
    }
}
