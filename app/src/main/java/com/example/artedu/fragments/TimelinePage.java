package com.example.artedu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artedu.R;
import com.example.artedu.adapters.TimelineAdapter;
import com.example.artedu.models.ArtMovement;
import com.example.artedu.utils.DataReader;

import java.util.ArrayList;

public class TimelinePage extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_timeline_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayList<ArtMovement> artMovements = getArtMovements();

        RecyclerView timelineRecyclerView = view.findViewById(R.id.timeline_recycler_view);
        TimelineAdapter timelineAdapter = new TimelineAdapter(requireContext(), artMovements);
        timelineRecyclerView.setAdapter(timelineAdapter);
        timelineRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    private ArrayList<ArtMovement> getArtMovements() {
        return DataReader.readMovementsFromAssets(requireContext(), "movements.json");
    }
}
