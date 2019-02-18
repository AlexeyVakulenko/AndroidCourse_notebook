package com.example.vakulenko.notebook.activity.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vakulenko.notebook.contract.ListContract;
import com.example.vakulenko.notebook.R;
import com.example.vakulenko.notebook.dao.entitys.Note;
import com.example.vakulenko.notebook.sp.Configuration;

import java.security.acl.LastOwnerException;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Holder> {

    public static final String TAG = "LIST_ADAPTER";
    public static final String NOT_FOUND = "NOT_FOUND";
    public static final String COLOR_ERR_MSG = "Не корректно задан цвет. ";

    private ListContract.Presenter presenter;

    public ListAdapter(Context context, ListContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup recicler, int i) {
        LayoutInflater inflater = LayoutInflater.from(recicler.getContext());
        return new Holder(inflater.inflate(R.layout.list_note, recicler, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int pos) {
        Note note = presenter.getNoteForPos(pos);
        if (note == null) {
            holder.bind(note.id, NOT_FOUND);
        }
        holder.bind(note.id, note.text);
    }

    @Override
    public int getItemCount() {
        return presenter.getNotesSize();
    }

    public class Holder extends RecyclerView.ViewHolder {

        public static final int MAX_LENGTH = 15;

        private TextView textView;

        private int id;

        public Holder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
            itemView.setOnClickListener(v -> presenter.toUpdateActivity(v, id));
        }

        public void bind(int id, String text) {
            Holder.this.id = id;
            textView.setTextSize(Integer.parseInt(Configuration.getValue(Configuration.ConfigurationName.TEXT_SIZE)));
            String colorString = Configuration.getValue(Configuration.ConfigurationName.TEXT_COLOR);
            try {
                textView.setTextColor(Color.parseColor(colorString));
            } catch (Exception e) {
                Log.d(TAG, COLOR_ERR_MSG + colorString);
            }
            textView.setText(text.length() <= MAX_LENGTH ? text : text.substring(0, MAX_LENGTH));
        }
    }
}
