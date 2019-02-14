package com.example.vakulenko.notebook.presenters;

import com.example.vakulenko.notebook.NoteRepository;
import com.example.vakulenko.notebook.UpdateContract;

public class UpdatePresenter implements UpdateContract.Presenter {

    private UpdateContract.View view;

    private NoteRepository repository;

    public UpdatePresenter(UpdateContract.View view) {
        this.view = view;
        repository = com.example.vakulenko.notebook.dao.NoteRepository.getInstance();
    }

    @Override
    public String getTextForId(int id) {
        return repository.getNote(id).text;
    }
}
