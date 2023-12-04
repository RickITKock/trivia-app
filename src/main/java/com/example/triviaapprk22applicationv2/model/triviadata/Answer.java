package com.example.triviaapprk22applicationv2.model.triviadata;

public class Answer extends QuizItem {
    private String submittedAnswer = "";
    private final String correctAnswer;
    private boolean isCorrect = false;

    public Answer(String questionText, String correctAnswer) {
        super(questionText);
        this.correctAnswer = correctAnswer;
    }

    public void setSubmittedAnswer(String submittedAnswer) {
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
}
