package com.example.triviaapprk22applicationv2.model;

public class Result {
    private Question question;
    private Answer answer;

    public Result(Question question, Answer answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question.getQuestion();
    }

    public String getCorrectAnswer() {
        return answer.getCorrectAnswer();
    }

    public String getSubmittedAnswer() {
        return answer.getSubmittedAnswer();
    }

    public boolean isCorrect() {
        return answer.isCorrect();
    }
}
