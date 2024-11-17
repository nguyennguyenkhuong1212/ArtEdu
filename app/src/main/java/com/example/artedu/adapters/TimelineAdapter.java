package com.example.artedu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artedu.R;
import com.example.artedu.models.ArtMovement;

import java.util.ArrayList;

public class TimelineAdapter extends RecyclerView.Adapter<TimelineAdapter.TimelineViewHolder> {
    private final Context context;
    private final ArrayList<ArtMovement> artMovements;

    public TimelineAdapter(Context context, ArrayList<ArtMovement> artMovements) {
        this.context = context;
        this.artMovements = artMovements;
    }

    @NonNull
    @Override
    public TimelineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_art_movement, parent, false);
        return new TimelineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TimelineViewHolder holder, int position) {
        ArtMovement movement = artMovements.get(position);
        holder.nameTextView.setText(movement.getName());
        holder.periodTextView.setText(movement.getPeriod());
        holder.descriptionTextView.setText(movement.getDescription());
    }

    @Override
    public int getItemCount() {
        return artMovements.size();
    }

    static class TimelineViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, periodTextView, descriptionTextView;

        public TimelineViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.art_movement_name);
            periodTextView = itemView.findViewById(R.id.art_movement_period);
            descriptionTextView = itemView.findViewById(R.id.art_movement_description);
        }
    }
}
