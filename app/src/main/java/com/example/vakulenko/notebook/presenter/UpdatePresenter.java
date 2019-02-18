package com.example.vakulenko.notebook.presenter;

import com.example.vakulenko.notebook.dao.NoteRepository;
import com.example.vakulenko.notebook.contract.UpdateContract;
import com.example.vakulenko.notebook.dao.NoteRepositoryImpl;

public class UpdatePresenter implements UpdateContract.Presenter {

    private UpdateContract.View view;

    private NoteRepository repository;

    public UpdatePresenter(UpdateContract.View view) {
        this.view = view;
        repository = NoteRepositoryImpl.getInstance();
    }

    @Override
    public String getTextForId(int id) {
        return repository.getNote(id).text;
    }

    @Override
    public void updateNote(int id, String text) {
        NoteRepositoryImpl.getInstance().updateNote(id, text);
    }
}
