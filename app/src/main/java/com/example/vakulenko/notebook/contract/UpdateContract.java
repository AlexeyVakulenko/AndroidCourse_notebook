package com.example.vakulenko.notebook.contract;

public interface UpdateContract {

    interface Presenter {
        String getTextForId(int id);
        void updateNote(int id, String text);
    }

    interface View {

    }
}
