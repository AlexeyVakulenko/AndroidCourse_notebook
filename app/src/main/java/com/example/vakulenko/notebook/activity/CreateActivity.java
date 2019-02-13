package com.example.vakulenko.notebook.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import com.example.vakulenko.notebook.CreateContract;
import com.example.vakulenko.notebook.R;
import com.example.vakulenko.notebook.pretenders.CreatePresenter;

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
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.createNote(editText.getText().toString());
    }
}
