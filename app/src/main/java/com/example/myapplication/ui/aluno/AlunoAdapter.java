package com.example.myapplication.ui.aluno;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.Aluno;

import java.util.List;

public class AlunoAdapter extends RecyclerView.Adapter<AlunoAdapter.ViewHolder> {
    private static final String TAG = "AlunoAdapter";

    private List<Aluno> mLista;

    public AlunoAdapter(List<Aluno> dataSet) {
        mLista = dataSet;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvId;
        private final TextView tvName;

        public ViewHolder(View v) {
            super(v);
            tvId = (TextView) v.findViewById(R.id.tvId);
            tvName = (TextView) v.findViewById(R.id.tvName);
        }

        public TextView getTvId() {
            return tvId;
        }

        public TextView getTvName() {
            return tvName;
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
        viewHolder.getTvId().setText(mLista.get(position).getId());
        viewHolder.getTvName().setText(mLista.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mLista.size();
    }
}