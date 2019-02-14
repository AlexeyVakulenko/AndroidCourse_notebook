package com.example.vakulenko.notebook.dao;

import com.example.vakulenko.notebook.CustomContext;
import com.example.vakulenko.notebook.entitys.Note;

import java.util.List;

public class NoteRepository implements com.example.vakulenko.notebook.NoteRepository {

    private static NoteRepository instance;

    private NoteDAO dao;

    private NoteRepository() {
        dao = CustomContext.getDB().getNoteDAO();
    }

    public static NoteRepository getInstance() {
        if (instance == null) {
            instance = new NoteRepository();
        }
        return instance;
    }

    @Override
    public void createNotes(List<Note> notes) {
        dao.insertAll(notes.toArray(new Note[notes.size()]));
    }

    @Override
    public List<Note> listNotes() {
        return dao.getAll();
    }

    @Override
    public Note getNote(int id) {
        return dao.getNoteById(id);
    }

    @Override
    public void deleteNote(int id) {
        dao.delete(dao.getNoteById(id));
    }

    @Override
    public void updateNote(int id, String text) {
        dao.update(id, text);
    }
}
