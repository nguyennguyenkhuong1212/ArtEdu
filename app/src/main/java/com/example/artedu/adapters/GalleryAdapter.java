package com.example.artedu.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artedu.R;
import com.example.artedu.callbacks.PaintingDiffCallback;
import com.example.artedu.models.Painting;

public class GalleryAdapter extends ListAdapter<Painting, GalleryAdapter.GalleryViewHolder> {

    private final OnImageClickListener onImageClickListener;

    public GalleryAdapter(OnImageClickListener onImageClickListener) {
        super(new PaintingDiffCallback());
        this.onImageClickListener = onImageClickListener;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_in_gallery_page, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        holder.bind(getItem(position), onImageClickListener);
    }

    static class GalleryViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final LinearLayout infoOverlay;
        private final TextView paintingTitle;
        private final TextView paintingMedium;
        private final TextView paintingLocation;
        private final TextView paintingDescription;
        private final TextView paintingArtist;
        private final TextView paintingYear;
        private final Button closeOverlayButton;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            infoOverlay = itemView.findViewById(R.id.info_overlay);
            paintingTitle = itemView.findViewById(R.id.painting_title);
            paintingMedium = itemView.findViewById(R.id.painting_medium);
            paintingLocation = itemView.findViewById(R.id.painting_location);
            paintingDescription = itemView.findViewById(R.id.painting_description);
            paintingArtist = itemView.findViewById(R.id.painting_artist);
            paintingYear = itemView.findViewById(R.id.painting_year);
            closeOverlayButton = itemView.findViewById(R.id.close_overlay_button);
        }

        @SuppressLint("SetTextI18n")
        public void bind(final Painting painting, final OnImageClickListener listener) {

            paintingTitle.setText(painting.getTitle());
            paintingMedium.setText("Medium: " + painting.getMedium());
            paintingLocation.setText("Location: " + painting.getLocation());
            paintingDescription.setText(painting.getDescription());
            paintingArtist.setText(painting.getArtist());
            paintingYear.setText(painting.getYear());

            imageView.setImageResource(painting.getImageResId());

            imageView.setOnClickListener(v -> {
                // Close all overlays first
                closeAllOverlays();
                infoOverlay.setVisibility(View.VISIBLE);
            });

            closeOverlayButton.setOnClickListener(v -> infoOverlay.setVisibility(View.GONE));
        }

        // Close all overlays
        private void closeAllOverlays() {
            RecyclerView recyclerView = (RecyclerView) itemView.getParent();
            if (recyclerView != null) {
                for (int i = 0; i < recyclerView.getChildCount(); i++) {
                    View itemView = recyclerView.getChildAt(i);
                    LinearLayout infoOverlay = itemView.findViewById(R.id.info_overlay);
                    if (infoOverlay != null) {
                        infoOverlay.setVisibility(View.GONE);
                    }
                }
            }
        }
    }

    public interface OnImageClickListener {
        void onImageClick(Painting painting);
    }
}
