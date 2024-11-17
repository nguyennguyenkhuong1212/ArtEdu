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
        paintingList.get(0).setImageResId(R.drawable.image1);
        paintingList.get(1).setImageResId(R.drawable.image2);
        paintingList.get(2).setImageResId(R.drawable.image3);
        paintingList.get(3).setImageResId(R.drawable.image4);
        paintingList.get(4).setImageResId(R.drawable.image5);
        paintingList.get(5).setImageResId(R.drawable.image6);
        paintingList.get(6).setImageResId(R.drawable.image7);
        paintingList.get(7).setImageResId(R.drawable.image8);
        adapter.submitList(paintingList);

        return view;
    }
}
