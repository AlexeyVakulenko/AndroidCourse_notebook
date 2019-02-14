package com.example.vakulenko.notebook.dao;

import com.example.vakulenko.notebook.contract.CustomContext;
import com.example.vakulenko.notebook.dao.entitys.Note;

import java.util.List;

public class NoteRepositoryImpl implements NoteRepository {

    private static NoteRepositoryImpl instance;

    private NoteDAO dao;

    private NoteRepositoryImpl() {
        dao = CustomContext.getDB().getNoteDAO();
    }

    public static NoteRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new NoteRepositoryImpl();
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
