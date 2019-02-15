package com.example.vakulenko.notebook.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.EditText;
import com.example.vakulenko.notebook.contract.CreateContract;
import com.example.vakulenko.notebook.R;
import com.example.vakulenko.notebook.presenter.CreatePresenter;

public class CreateActivity extends Activity implements CreateContract.View {

    private CreateContract.Presenter presenter;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        presenter = new CreatePresenter(this);
        editText = findViewById(R.id.edit_text);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setTextSize();
        presenter.setTextColor();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.createNote(editText.getText().toString());
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, CreateActivity.class);
    }

    @Override
    public void setTextSize(int i) {
        editText.setTextSize(i);
    }

    @Override
    public void setTextColor(String color) {
        //TODO
        editText.setTextColor(Color.parseColor(color));
    }
}

