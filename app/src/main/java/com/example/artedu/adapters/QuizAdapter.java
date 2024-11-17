package com.example.artedu.adapters;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import com.example.artedu.R;
import com.example.artedu.models.Question;
import com.example.artedu.utils.DataReader;

import java.util.Collections;
import java.util.List;

public class QuizAdapter extends Fragment {
    private TextView questionTitle;
    private RadioGroup optionsRadioGroup;
    private List<Question> quizQuestions;
    private int currentQuestionIndex = 0;

    @SuppressLint("SetTextI18n")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.quiz_questions_display, container, false);

        questionTitle = view.findViewById(R.id.question_title);
        optionsRadioGroup = view.findViewById(R.id.options_radio_group);
        Button backButton = view.findViewById(R.id.back_button);
        Button nextButton = view.findViewById(R.id.next_button);

        List<Question> allQuestions = getSampleQuestions();
        quizQuestions = pickRandomQuestions(allQuestions);

        assert getActivity() != null;
        TextView quizResetTitle = getActivity().findViewById(R.id.quiz_reset_title);
        Button restartQuizButton = getActivity().findViewById(R.id.restart_quiz_button);
        FragmentContainerView quizDisplay = getActivity().findViewById(R.id.quiz_fragment_container);

        showQuestion(quizQuestions.get(currentQuestionIndex));

        backButton.setOnClickListener(v -> {
            if (currentQuestionIndex > 0) {
                saveUserSelectedOption();
                currentQuestionIndex--;
                if (currentQuestionIndex <= 0) {
                    backButton.setVisibility(View.GONE);
                }
                if (currentQuestionIndex < quizQuestions.size() - 1) {
                    nextButton.setText("Next");
                }
                showQuestion(quizQuestions.get(currentQuestionIndex));
            }
        });

        nextButton.setOnClickListener(v -> {
            if (currentQuestionIndex < quizQuestions.size() - 1) {
                saveUserSelectedOption();
                currentQuestionIndex++;
                if (currentQuestionIndex > 0) {
                    backButton.setVisibility(View.VISIBLE);
                }
                if (currentQuestionIndex == quizQuestions.size() - 1) {
                    nextButton.setText("Finish");
                }
                showQuestion(quizQuestions.get(currentQuestionIndex));
            } else {
                saveUserSelectedOption();
                revealMarks();

                quizResetTitle.setVisibility(View.VISIBLE);
                restartQuizButton.setVisibility(View.VISIBLE);
                quizDisplay.setVisibility(View.GONE);
            }
        });

        return view;
    }

    private void showQuestion(Question question) {
        questionTitle.setText(question.getQuestionText());
        optionsRadioGroup.removeAllViews();

        for (int i = 0; i < question.getOptions().size(); i++) {
            String option = question.getOptions().get(i);
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setText(option);
            radioButton.setId(View.generateViewId());
            radioButton.setButtonTintList(ContextCompat.getColorStateList(requireContext(), R.color.black));
            radioButton.setTextColor(ContextCompat.getColorStateList(requireContext(), R.color.black));
            optionsRadioGroup.addView(radioButton);

            if (question.getUserSelectedOption() == i) {
                radioButton.setChecked(true);
            }
        }
    }

    private void saveUserSelectedOption() {
        int selectedOptionId = optionsRadioGroup.getCheckedRadioButtonId();
        if (selectedOptionId != -1) {
            RadioButton selectedRadioButton = optionsRadioGroup.findViewById(selectedOptionId);
            int selectedOptionIndex = optionsRadioGroup.indexOfChild(selectedRadioButton);
            quizQuestions.get(currentQuestionIndex).setUserSelectedOption(selectedOptionIndex);
        }
    }

    private void revealMarks() {
        int correctAnswers = 0;
        for (Question question : quizQuestions) {
            if (question.getUserSelectedOption() == question.getCorrectAnswerIndex()) {
                correctAnswers++;
            }
        }
        Toast.makeText(getContext(), "You got " + correctAnswers + " out of " + quizQuestions.size() + " correct!", Toast.LENGTH_LONG).show();
    }

    private List<Question> getSampleQuestions() {
        return DataReader.readQuestionsFromAssets(requireContext(), "questions.json");
    }

    private List<Question> pickRandomQuestions(List<Question> allQuestions) {
        Collections.shuffle(allQuestions);
        return allQuestions.subList(0, Math.min(10, allQuestions.size()));
    }
}
