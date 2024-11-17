package com.example.artedu.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artedu.R;
import com.example.artedu.adapters.GalleryAdapter;
import com.example.artedu.models.Painting;
import com.example.artedu.utils.DataReader;

import java.util.List;

public class GalleryPage extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_gallery_page, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));

        GalleryAdapter adapter = new GalleryAdapter(painting -> {});
        recyclerView.setAdapter(adapter);

        List<Painting> paintingList = DataReader.readPaintingsFromAssets(requireContext(), "paintings.json");
        if (paintingList == null) {
            Log.e("GalleryPage", "Failed to load paintings from JSON. The list is null.");
        } else {
            Log.d("GalleryPage", "Number of paintings: " + paintingList.size());

            // Optionally print each painting
            for (Painting painting : paintingList) {
                Log.d("GalleryPage", "Painting: " + painting.toString());
            }
        }
        adapter.submitList(paintingList);

        return view;
    }
}
