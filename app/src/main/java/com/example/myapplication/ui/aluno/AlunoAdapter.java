package com.example.myapplication.ui.aluno;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class AlunoAdapter extends RecyclerView.Adapter<AlunoAdapter.ViewHolder> {
    private static final String TAG = "AlunoAdapter";

    private List<String> mLista;

    public AlunoAdapter(List<String> dataSet) {
        mLista = dataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.tvName);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_aluno, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        viewHolder.getTextView().setText(mLista.get(position));
    }

    @Override
    public int getItemCount() {
        return mLista.size();
    }
}