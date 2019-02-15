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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        presenter = new ConfigPresenter(this);
        textSizeEditText = findViewById(R.id.text_size_edit_text);
    }


    @Override
    protected void onPause() {
        super.onPause();
        presenter.changeTextSize(Integer.parseInt(textSizeEditText.getText().toString()));
    }

    public static Intent createIntent(Context context) {
        Intent intent = new Intent(context, ConfigActivity.class);
        return intent;
    }
}
