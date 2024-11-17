package com.example.artedu.models;

import java.util.List;

public class Question {
    private final String questionText;
    private final List<String> options;
    private final int correctAnswerIndex;
    private int userSelectedOption = -1;

    public Question(String questionText, List<String> options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public int getUserSelectedOption() {
        return userSelectedOption;
    }

    public void setUserSelectedOption(int userSelectedOption) {
        this.userSelectedOption = userSelectedOption;
    }
}
