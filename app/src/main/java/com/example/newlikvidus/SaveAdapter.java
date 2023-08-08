package com.example.newlikvidus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.newlikvidus.data.entities.Save;

import java.util.List;

public class SaveAdapter extends RecyclerView.Adapter<SaveAdapter.ViewHolder>{
    private LayoutInflater inflater;
    private List<Save> saves;
    private List<Float> values;

    public SaveAdapter(Context context, List<Save> saves, List<Float> values) {
        this.saves = saves;
        this.values = values;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public SaveAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.save_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SaveAdapter.ViewHolder holder, int position) {
        Save save = saves.get(position);
        float value = values.get(position);
        holder.nameView.setText(save.getName());
        holder.descriptionView.setText(save.getDescription());
        holder.dateView.setText(save.getDate());
        holder.resultView.setText(String.valueOf(value));
    }

    @Override
    public int getItemCount() {
        return saves.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, descriptionView, dateView, resultView;
        ViewHolder(View view){
            super(view);
            nameView = view.findViewById(R.id.name);
            descriptionView = view.findViewById(R.id.description);
            dateView = view.findViewById(R.id.date);
            resultView = view.findViewById(R.id.result);
        }
    }
}
