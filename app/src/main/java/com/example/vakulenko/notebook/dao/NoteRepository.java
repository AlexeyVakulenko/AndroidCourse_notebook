package com.example.vakulenko.notebook.dao;

import com.example.vakulenko.notebook.dao.entitys.Note;

import java.util.List;

public interface NoteRepository {
    void createNotes(List<Note> notes);
    List<Note> listNotes();
    Note getNote(int id);
    void deleteNote(int id);
    void updateNote(int id, String text);
}
