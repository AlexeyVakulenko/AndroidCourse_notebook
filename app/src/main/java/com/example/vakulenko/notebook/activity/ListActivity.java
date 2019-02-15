package com.example.vakulenko.notebook.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.vakulenko.notebook.contract.ListContract;
import com.example.vakulenko.notebook.R;
import com.example.vakulenko.notebook.activity.adapter.ListAdapter;
import com.example.vakulenko.notebook.presenter.ListPresenter;


public class ListActivity extends Activity implements ListContract.View {

    private ListContract.Presenter presenter;

    private Button createButton;

    private Button configButton;

    private RecyclerView recyclerView;

    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        presenter = new ListPresenter(this);
        createButton = findViewById(R.id.create_button);
        createButton.setOnClickListener(v -> presenter.createNote());
        configButton = findViewById(R.id.config_button);
        configButton.setOnClickListener(v -> presenter.toConfigActivity());
        recyclerView = findViewById(R.id.recycler_view);
        listAdapter = new ListAdapter(this, presenter);
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listAdapter.notifyDataSetChanged();
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

    @Override
    public void toConfigActivity() {
        startActivity(ConfigActivity.createIntent(this));
    }
}
