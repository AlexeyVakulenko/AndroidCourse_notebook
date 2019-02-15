package com.example.vakulenko.notebook.contract;

import com.example.vakulenko.notebook.dao.entitys.Note;

public interface ListContract {
    interface View {
        void createNote();
        void toCreateActivity();
        void toUpdateActivity(android.view.View v, int id);
        void toConfigActivity();
    }

    interface Presenter {
        void createNote();
        void toCreateActivity();
        Note getNoteForPos(int id);
        int getNotesSize();
        void toUpdateActivity(android.view.View v, int id);
        void toConfigActivity();
    }
}

