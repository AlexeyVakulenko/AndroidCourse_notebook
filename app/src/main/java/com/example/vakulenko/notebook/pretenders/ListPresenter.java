package com.example.vakulenko.notebook.pretenders;

import com.example.vakulenko.notebook.ListContract;
import com.example.vakulenko.notebook.dao.NoteRepository;
import com.example.vakulenko.notebook.entitys.Note;

import java.util.List;

public class ListPresenter implements ListContract.Presenter {

    private ListContract.View view;

    private com.example.vakulenko.notebook.NoteRepository repository;

    public ListPresenter(ListContract.View view) {
        this.view = view;
        repository = NoteRepository.getInstance();
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
    public String getNoteTextForPos(int pos) {
        List<Note> notes = repository.listNotes();
        Note note = null;
        if (!notes.isEmpty()) {
            note = repository.listNotes().get(notes.size() - 1 - pos);
        }
        return note != null ? note.text : null;
    }

    @Override
    public int getNotesSize() {
        return repository.listNotes().size();
    }
}
