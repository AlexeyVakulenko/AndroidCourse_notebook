package com.example.vakulenko.notebook.presenter;

import android.content.SharedPreferences;
import com.example.vakulenko.notebook.contract.ConfigContract;
import com.example.vakulenko.notebook.sp.Configuration;

public class ConfigPresenter implements ConfigContract.Presenter {

    private ConfigContract.View view;

    public ConfigPresenter(ConfigContract.View view) {
        this.view = view;

    }

    @Override
    public void changeTextSize(int size) {
        Configuration.setValue(Configuration.ConfigurationName.TEXT_SIZE, String.valueOf(size));
    }

    @Override
    public void changeTextColor(int color) {
        Configuration.setValue(Configuration.ConfigurationName.TEXT_COLOR, String.valueOf(color));
    }
}
