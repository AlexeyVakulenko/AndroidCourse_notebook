package com.example.vakulenko.notebook.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import com.example.vakulenko.notebook.R;
import com.example.vakulenko.notebook.contract.UpdateContract;
import com.example.vakulenko.notebook.dao.NoteRepositoryImpl;
import com.example.vakulenko.notebook.presenter.UpdatePresenter;

public class UpdateActivity extends Activity implements UpdateContract.View {

    public static final String ID = "id";

    private UpdateContract.Presenter presenter;

    private int id;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        editText = findViewById(R.id.edit_text);
        this.presenter = new UpdatePresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        id = getIntent().getIntExtra(ID, -1);
        editText.setText(presenter.getTextForId(id));
    }

    @Override
    protected void onPause() {
        super.onPause();
        NoteRepositoryImpl.getInstance().updateNote(id, editText.getText().toString());
    }

    public static Intent createIntent(Context context, int id) {
        Intent intent = new Intent(context, UpdateActivity.class);
        intent.putExtra(ID, id);
        return intent;
    }
}
