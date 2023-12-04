package com.example.triviaapprk22applicationv2.model;

public class Result {
    private PreparedMultipleChoiceQuestion question;
    private Answer answer;

    public Result(PreparedMultipleChoiceQuestion question, Answer answer) {
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
