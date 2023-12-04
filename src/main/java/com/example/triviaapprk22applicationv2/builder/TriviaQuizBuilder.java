package com.example.triviaapprk22applicationv2.builder;

import com.example.triviaapprk22applicationv2.model.Question;
import com.example.triviaapprk22applicationv2.model.PreparedMultipleChoiceQuestion;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TriviaQuizBuilder {
    private Question[] questions;

    public TriviaQuizBuilder(Question[] questions) {
        this.questions = questions;
    }

    public PreparedMultipleChoiceQuestion[] getPreparedMultipleChoiceQuestions() {
        PreparedMultipleChoiceQuestion[] preparedMultipleChoiceQuestions = new PreparedMultipleChoiceQuestion[questions.length];
        for (int i = 0 ; i < preparedMultipleChoiceQuestions.length; i++) {
            preparedMultipleChoiceQuestions[i] = getPreparedMultipleChoiceQuestion(questions[i]);
            preparedMultipleChoiceQuestions[i].setId(i);
        }
        return preparedMultipleChoiceQuestions;
    }

    public PreparedMultipleChoiceQuestion getPreparedMultipleChoiceQuestion(Question question) {
        PreparedMultipleChoiceQuestion preparedMultipleChoiceQuestion = new PreparedMultipleChoiceQuestion();
        preparedMultipleChoiceQuestion.setQuestion(question.getQuestion());
        preparedMultipleChoiceQuestion.setCorrectAnswer(question.getCorrectAnswer());
        String [] incorrectAnswers = question.getIncorrectAnswers();
        String [] allPossibleAnswers = new String[incorrectAnswers.length + 1];
        for (int i = 0 ; i < incorrectAnswers.length; i++) {
            allPossibleAnswers[i] = incorrectAnswers[i];
        }
        allPossibleAnswers[allPossibleAnswers.length - 1] = question.getCorrectAnswer();
        allPossibleAnswers = getShuffledStringArray(allPossibleAnswers);
        preparedMultipleChoiceQuestion.setAllPossibleAnswers(allPossibleAnswers);
        return preparedMultipleChoiceQuestion;
    }

    // Consider using the getShuffledStringArray as a utility method/class
    private String[] getShuffledStringArray(String[] stringArray) {
        String [] shuffledArrayResult = stringArray;
        Random rnd = ThreadLocalRandom.current();

        for (int i = stringArray.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String str = shuffledArrayResult[index];
            shuffledArrayResult[index] = shuffledArrayResult[i];
            shuffledArrayResult[i] = str;
        }
        return shuffledArrayResult;
    }
}
