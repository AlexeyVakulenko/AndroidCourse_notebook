package com.example.vakulenko.notebook;

import android.view.View;
import com.example.vakulenko.notebook.entitys.Note;

import java.util.List;

public interface ListContract {
    interface View {
        void createNote();
        void toCreateActivity();
        void toUpdateActivity(android.view.View v, int id);
    }

    interface Presenter {
        void createNote();
        void toCreateActivity();
        Note getNoteForPos(int id);
        int getNotesSize();

        void toUpdateActivity(android.view.View v, int id);
    }
}

