package com.example.vakulenko.notebook.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import com.example.vakulenko.notebook.R;
import com.example.vakulenko.notebook.contract.ConfigContract;
import com.example.vakulenko.notebook.presenter.ConfigPresenter;

public class ConfigActivity extends Activity implements ConfigContract.View {

    private ConfigContract.Presenter presenter;

    private EditText textSizeEditText;

    private EditText textColorEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        presenter = new ConfigPresenter(this);
        textSizeEditText = findViewById(R.id.text_size_edit_text);
        textColorEditText = findViewById(R.id.text_color_edit_text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setCurrentTextSize();
        presenter.setCurrentTextColor();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.changeTextSize(textSizeEditText.getText().toString());
        presenter.changeTextColor(textColorEditText.getText().toString());
    }

    @Override
    public void setCurrentTextSize(String textSize) {
        textSizeEditText.setText(textSize);
    }

    @Override
    public void setCurrentTextColor(String textColor) {
        textColorEditText.setText(textColor);
    }

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, ConfigActivity.class);
        return intent;
    }
}
