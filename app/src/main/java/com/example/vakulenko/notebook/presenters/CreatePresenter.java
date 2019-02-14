package com.example.vakulenko.notebook.presenters;

import com.example.vakulenko.notebook.CreateContract;
import com.example.vakulenko.notebook.NoteRepository;
import com.example.vakulenko.notebook.entitys.Note;

import java.util.Arrays;

public class CreatePresenter implements CreateContract.Presenter {

    private CreateContract.View view;

    private NoteRepository repository;

    public CreatePresenter(CreateContract.View view) {
        this.view = view;
        repository = com.example.vakulenko.notebook.dao.NoteRepository.getInstance();
    }

    @Override
    public void createNote(String text) {
        if (!text.isEmpty()) {
            repository.createNotes(Arrays.asList(new Note(text)));
        }
    }
}
