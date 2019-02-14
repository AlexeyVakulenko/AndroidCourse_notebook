package com.example.vakulenko.notebook.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.vakulenko.notebook.ListContract;
import com.example.vakulenko.notebook.R;
import com.example.vakulenko.notebook.adapters.NoteAdapter;
import com.example.vakulenko.notebook.presenters.ListPresenter;


public class ListActivity extends Activity implements ListContract.View {

    private ListContract.Presenter presenter;

    private Button createButton;

    private RecyclerView recyclerView;

    private NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        presenter = new ListPresenter(this);
        createButton = findViewById(R.id.create_button);
        createButton.setOnClickListener(v -> presenter.createNote());
        recyclerView = findViewById(R.id.recycler_view);
        noteAdapter = new NoteAdapter(this, presenter);
        recyclerView.setAdapter(noteAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        noteAdapter.notifyDataSetChanged();
    }

    @Override
    public void createNote() {
        presenter.toCreateActivity();
    }

    @Override
    public void toUpdateActivity(View view, int id) {
        startActivity(UpdateActivity.createIntent(this, id));
    }

    @Override
    public void toCreateActivity() {
        startActivity(CreateActivity.createIntent(this));
    }
}
