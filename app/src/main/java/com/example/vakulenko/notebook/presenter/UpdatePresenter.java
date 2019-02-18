package com.example.vakulenko.notebook.presenter;

import com.example.vakulenko.notebook.dao.NoteRepository;
import com.example.vakulenko.notebook.contract.UpdateContract;
import com.example.vakulenko.notebook.dao.NoteRepositoryImpl;
import com.example.vakulenko.notebook.sp.Configuration;

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

    @Override
    public void setTextSize() {
        int size = Integer.parseInt(Configuration.getValue(Configuration.ConfigurationName.TEXT_SIZE));
        view.setTextSize(size);
    }

    @Override
    public void setTextColor() {
        String color = Configuration.getValue(Configuration.ConfigurationName.TEXT_COLOR);
        view.setTextColor(color);
    }
}
