package com.example.vakulenko.notebook;

import com.example.vakulenko.notebook.entitys.Note;

import java.util.List;

public interface ListContract {
    interface View {
        void createNote();
        void toCreateActivity();
    }

    interface Presenter {
        void createNote();
        void toCreateActivity();
        String getNoteTextForPos(int id);
        int getNotesSize();
    }
}

