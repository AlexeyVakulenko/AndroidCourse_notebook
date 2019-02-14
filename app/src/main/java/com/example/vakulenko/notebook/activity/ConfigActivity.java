package com.example.vakulenko.notebook.activity;

import android.app.Activity;
import android.os.Bundle;
import com.example.vakulenko.notebook.R;
import com.example.vakulenko.notebook.contract.ConfigContract;
import com.example.vakulenko.notebook.presenter.ConfigPresenter;

public class ConfigActivity extends Activity implements ConfigContract.View {

    private ConfigContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        presenter = new ConfigPresenter(this);
    }
}
