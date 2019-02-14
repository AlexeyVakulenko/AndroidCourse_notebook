package com.example.vakulenko.notebook.contract;

public interface ConfigContract {

    interface Presenter {
        void changeTextSize(int size);
        void changeTextColor(int color);
    }

    interface View {
    }
}
