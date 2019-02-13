package com.example.vakulenko.notebook.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.example.vakulenko.notebook.entitys.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract NoteDAO getNoteDAO();
}
