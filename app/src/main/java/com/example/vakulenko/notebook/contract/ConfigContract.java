package com.example.vakulenko.notebook.contract;

public interface ConfigContract {

    interface Presenter {
        void changeTextSize(String size);
        void changeTextColor(String color);
    }

    interface View {
    }
}
