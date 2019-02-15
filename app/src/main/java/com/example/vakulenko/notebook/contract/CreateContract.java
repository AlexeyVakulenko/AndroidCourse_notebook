package com.example.vakulenko.notebook.contract;

public interface CreateContract {

    interface Presenter {
        void createNote(String text);
        void setTextSize();
        void setTextColor();
    }

    interface View {
        void setTextSize(int i);
        void setTextColor(String color);
    }
}
