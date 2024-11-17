package com.example.artedu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.artedu.fragments.GalleryPage;
import com.example.artedu.fragments.HomePage;
import com.example.artedu.fragments.QuizPage;
import com.example.artedu.fragments.TimelinePage;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setSelectedItemId(R.id.home);
        bottomNav.setOnItemSelectedListener(navListener);

        Fragment selectedFragment = new HomePage();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                selectedFragment).commit();

    }

    private final NavigationBarView.OnItemSelectedListener navListener =
            item -> {
                int itemId = item.getItemId();
                Fragment selectedFragment = null;

                if (itemId == R.id.home) {
                    selectedFragment = new HomePage();
                } else if (itemId == R.id.gallery) {
                    selectedFragment = new GalleryPage();
                } else if (itemId == R.id.quiz) {
                    selectedFragment = new QuizPage();
                } else if (itemId == R.id.timeline) {
                    selectedFragment = new TimelinePage();
                } else {
                    selectedFragment = new HomePage(); // Default
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                return true;
            };

}