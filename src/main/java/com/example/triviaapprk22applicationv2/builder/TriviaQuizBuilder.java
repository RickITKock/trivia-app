package com.example.triviaapprk22applicationv2.builder;

import com.example.triviaapprk22applicationv2.model.triviadata.MultipleChoiceQuestion;
import com.example.triviaapprk22applicationv2.model.triviadata.PreparedMultipleChoiceQuestion;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TriviaQuizBuilder {
    private MultipleChoiceQuestion[] multipleChoiceQuestions;

    public TriviaQuizBuilder(MultipleChoiceQuestion[] multipleChoiceQuestions) {
        this.multipleChoiceQuestions = multipleChoiceQuestions;
    }

    public PreparedMultipleChoiceQuestion[] getPreparedMultipleChoiceQuestions() {
        PreparedMultipleChoiceQuestion[] preparedMultipleChoiceQuestions = new PreparedMultipleChoiceQuestion[multipleChoiceQuestions.length];
        for (int i = 0 ; i < preparedMultipleChoiceQuestions.length; i++) {
            preparedMultipleChoiceQuestions[i] = getPreparedMultipleChoiceQuestion(multipleChoiceQuestions[i]);
        }
        return preparedMultipleChoiceQuestions;
    }

    public PreparedMultipleChoiceQuestion getPreparedMultipleChoiceQuestion(MultipleChoiceQuestion multipleChoiceQuestion) {
        PreparedMultipleChoiceQuestion preparedMultipleChoiceQuestion = new PreparedMultipleChoiceQuestion();
        preparedMultipleChoiceQuestion.setQuestion(multipleChoiceQuestion.getQuestion());
        String [] incorrectAnswers = multipleChoiceQuestion.getIncorrectAnswers();
        String [] allPossibleAnswers = new String[incorrectAnswers.length + 1];
        for (int i = 0 ; i < incorrectAnswers.length; i++) {
            allPossibleAnswers[i] = incorrectAnswers[i];
        }
        allPossibleAnswers[allPossibleAnswers.length - 1] = multipleChoiceQuestion.getCorrectAnswer();
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
