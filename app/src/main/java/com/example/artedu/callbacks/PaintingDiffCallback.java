package com.example.artedu.callbacks;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import com.example.artedu.models.Painting;

public class PaintingDiffCallback extends DiffUtil.ItemCallback<Painting> {
    @Override
    public boolean areItemsTheSame(@NonNull Painting oldItem, @NonNull Painting newItem) {
        return oldItem.getTitle().equals(newItem.getTitle());
    }

    @SuppressLint("DiffUtilEquals")
    @Override
    public boolean areContentsTheSame(@NonNull Painting oldItem, @NonNull Painting newItem) {
        return oldItem.equals(newItem);
    }
}
