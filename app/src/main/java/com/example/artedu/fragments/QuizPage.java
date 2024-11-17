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
import com.example.artedu.adapters.QuizAdapter;

public class QuizPage extends Fragment {
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_quiz_page, container, false);

        Button startQuizButton = view.findViewById(R.id.start_quiz_button);
        startQuizButton.setOnClickListener(v -> startQuiz());

        Button restartQuizButton = view.findViewById(R.id.restart_quiz_button);
        restartQuizButton.setOnClickListener(v -> startQuiz());

        return view;
    }

    private void startQuiz() {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.quiz_fragment_container, new QuizAdapter());
        transaction.commit();

        // Make the fragment container visible and hide the start button
        view.findViewById(R.id.quiz_fragment_container).setVisibility(View.VISIBLE);
        view.findViewById(R.id.start_quiz_button).setVisibility(View.GONE);
        view.findViewById(R.id.greeting_title).setVisibility(View.GONE);
        view.findViewById(R.id.quiz_reset_title).setVisibility(View.GONE);
        view.findViewById(R.id.restart_quiz_button).setVisibility(View.GONE);
    }
}
