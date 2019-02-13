package com.example.vakulenko.notebook.dao;

import android.arch.persistence.room.*;
import com.example.vakulenko.notebook.entitys.Note;

import java.util.List;

@Dao
public interface NoteDAO {

    @Query("SELECT * FROM notes WHERE id = :id")
    Note getNoteById(int id);

    @Query("SELECT * FROM notes")
    List<Note> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Note... notes);

    @Delete
    void delete(Note note);
}
