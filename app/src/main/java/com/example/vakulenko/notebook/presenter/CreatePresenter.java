package com.example.vakulenko.notebook.presenter;

import android.graphics.Color;
import com.example.vakulenko.notebook.contract.CreateContract;
import com.example.vakulenko.notebook.dao.NoteRepository;
import com.example.vakulenko.notebook.dao.NoteRepositoryImpl;
import com.example.vakulenko.notebook.dao.entitys.Note;
import com.example.vakulenko.notebook.sp.Configuration;

import java.util.Arrays;

public class CreatePresenter implements CreateContract.Presenter {

    private CreateContract.View view;

    private NoteRepository repository;

    public CreatePresenter(CreateContract.View view) {
        this.view = view;
        repository = NoteRepositoryImpl.getInstance();
    }

    @Override
    public void createNote(String text) {
        if (!text.isEmpty()) {
            repository.createNotes(Arrays.asList(new Note(text)));
        }
    }

    @Override
    public void setTextSize() {
        int size = Integer.parseInt(Configuration.getValue(Configuration.ConfigurationName.TEXT_SIZE));
        view.setTextSize(size);
    }

    @Override
    public void setTextColor() {
        String color = Configuration.getValue(Configuration.ConfigurationName.TEXT_COLOR);
        //TODO
        view.setTextColor(color);
    }
}
