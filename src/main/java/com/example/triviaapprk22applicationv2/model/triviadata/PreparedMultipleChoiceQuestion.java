package com.example.triviaapprk22applicationv2.model.triviadata;

import java.util.Arrays;

public class PreparedMultipleChoiceQuestion {
    private int id;

    private String question;

    private String correctAnswer;
    private String[] allPossibleAnswers;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getCorrectAnswer() {
        return this.correctAnswer;
    }

    public String[] getAllPossibleAnswers() {
        return allPossibleAnswers;
    }

    public void setAllPossibleAnswers(String[] allPossibleAnswers) {
        this.allPossibleAnswers = allPossibleAnswers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PreparedMultipleChoiceQuestion{" +
                "question='" + question + '\'' +
                ", allPossibleAnswers=" + Arrays.toString(allPossibleAnswers) +
                '}';
    }
}
