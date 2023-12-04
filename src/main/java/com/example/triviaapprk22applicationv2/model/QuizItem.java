package com.example.triviaapprk22applicationv2.model;

public class QuizItem {
    private String questionText;

    public QuizItem(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}
