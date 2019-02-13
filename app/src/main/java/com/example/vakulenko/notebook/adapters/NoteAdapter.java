package com.example.vakulenko.notebook.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vakulenko.notebook.ListContract;
import com.example.vakulenko.notebook.R;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.Holder> {

    private ListContract.Presenter presenter;

    public NoteAdapter(Context context, ListContract.Presenter presenter) {
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
        String text = presenter.getNoteTextForPos(pos);
        if (text == null || text.isEmpty()) {
            text = "NOT_FOUND";
        }
        holder.bind(text);
    }

    @Override
    public int getItemCount() {
        return presenter.getNotesSize();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        private TextView textView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }

        public void bind(String text) {
            textView.setText(text);
        }
    }
}
