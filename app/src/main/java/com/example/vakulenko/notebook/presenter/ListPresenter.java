package com.example.vakulenko.notebook.presenter;

import android.view.View;
import com.example.vakulenko.notebook.contract.ListContract;
import com.example.vakulenko.notebook.dao.NoteRepository;
import com.example.vakulenko.notebook.dao.NoteRepositoryImpl;
import com.example.vakulenko.notebook.dao.entitys.Note;

import java.util.List;

public class ListPresenter implements ListContract.Presenter {

    private ListContract.View view;

    private NoteRepository repository;

    public ListPresenter(ListContract.View view) {
        this.view = view;
        repository = NoteRepositoryImpl.getInstance();
    }

    @Override
    public void createNote() {
        view.createNote();
    }

    @Override
    public void toCreateActivity() {
        view.toCreateActivity();
    }

    @Override
    public Note getNoteForPos(int pos) {
        List<Note> notes = repository.listNotes();
        Note note = null;
        if (!notes.isEmpty()) {
            note = repository.listNotes().get(notes.size() - 1 - pos);
        }
        return note;
    }

    @Override
    public int getNotesSize() {
        return repository.listNotes().size();
    }

    @Override
    public void toUpdateActivity(View v, int id) {
        view.toUpdateActivity(v, id);
    }
}
