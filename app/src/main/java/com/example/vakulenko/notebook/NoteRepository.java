package com.example.vakulenko.notebook;

import com.example.vakulenko.notebook.entitys.Note;

import java.util.List;

public interface NoteRepository {
    void createNotes(List<Note> notes);
    List<Note> listNotes();
    Note getNote(int id);
    void deleteNote(int id);
    void updateNote(int id, String text);
}
