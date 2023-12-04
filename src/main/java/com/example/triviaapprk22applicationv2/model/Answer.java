package com.example.triviaapprk22applicationv2.model;

public class Answer {
    private String submittedAnswer = "";
    private final String correctAnswer;
    private boolean isCorrect = false;

    public Answer(String correctAnswer, String submittedAnswer) {
        this.correctAnswer = correctAnswer;
        this.submittedAnswer = submittedAnswer != null ? submittedAnswer.trim() : "";
        checkAndSetIsCorrect();
    }

    private void checkAndSetIsCorrect() {
        this.isCorrect = correctAnswer.trim().equalsIgnoreCase(submittedAnswer);
    }

    public String getSubmittedAnswer() {
        return submittedAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "submittedAnswer='" + submittedAnswer + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }

}
