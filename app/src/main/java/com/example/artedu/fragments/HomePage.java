package com.example.artedu.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.artedu.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class HomePage extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = inflater.inflate(R.layout.activity_home_page, container, false);

        Button startDiscoverButton = view.findViewById(R.id.start_discover_button);
        // Navigate to the GalleryPage fragment
        startDiscoverButton.setOnClickListener(v -> {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new GalleryPage())
                        .commit();
            BottomNavigationView bottomNavigationView =
                    requireActivity().findViewById(R.id.bottom_navigation);
            bottomNavigationView.setSelectedItemId(R.id.gallery);
        });

        return view;
    }
}