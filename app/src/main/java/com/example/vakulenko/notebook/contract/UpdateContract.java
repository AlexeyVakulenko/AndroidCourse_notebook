package com.example.vakulenko.notebook.contract;

public interface UpdateContract {

    interface Presenter {
        String getTextForId(int id);

        void updateNote(int id, String text);

        void setTextSize();

        void setTextColor();
    }

    interface View {
        void setTextSize(int i);

        void setTextColor(String color);
    }
}
