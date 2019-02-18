package com.example.vakulenko.notebook.presenter;

import android.text.TextUtils;
import com.example.vakulenko.notebook.contract.ConfigContract;
import com.example.vakulenko.notebook.sp.Configuration;

public class ConfigPresenter implements ConfigContract.Presenter {

    private ConfigContract.View view;

    public ConfigPresenter(ConfigContract.View view) {
        this.view = view;
    }

    @Override
    public void changeTextSize(String size) {
        if (size != null && !size.isEmpty() && TextUtils.isDigitsOnly(size)) {
            Configuration.setValue(Configuration.ConfigurationName.TEXT_SIZE, size);
        }
    }

    @Override
    public void changeTextColor(String color) {
        if (color != null && !color.isEmpty()) {
            Configuration.setValue(Configuration.ConfigurationName.TEXT_COLOR, color);
        }
    }

    @Override
    public void setCurrentTextSize() {
        view.setCurrentTextSize(Configuration.getValue(Configuration.ConfigurationName.TEXT_SIZE));
    }

    @Override
    public void setCurrentTextColor() {
        view.setCurrentTextColor(Configuration.getValue(Configuration.ConfigurationName.TEXT_COLOR));
    }
}
