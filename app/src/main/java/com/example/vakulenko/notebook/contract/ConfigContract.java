package com.example.vakulenko.notebook.contract;

public interface ConfigContract {

    interface Presenter {
        void changeTextSize(String size);
        void changeTextColor(String color);

        void setCurrentTextSize();

        void setCurrentTextColor();
    }

    interface View {
        void setCurrentTextSize(String textSize);
        void setCurrentTextColor(String textColor);
    }
}
