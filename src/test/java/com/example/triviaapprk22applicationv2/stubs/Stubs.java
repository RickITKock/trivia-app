package com.example.triviaapprk22applicationv2.stubs;

import com.example.triviaapprk22applicationv2.model.triviadata.TriviaData;
import com.example.triviaapprk22applicationv2.model.triviadata.MultipleChoiceQuestion;

public class Stubs {
    public static TriviaData createDummyTriviaDataObject(MultipleChoiceQuestion[] multipleChoiceQuestionsArray) {
        TriviaData dummyTriviaDataObject = new TriviaData();
        dummyTriviaDataObject.setMultipleChoiceQuestions(multipleChoiceQuestionsArray);
        return dummyTriviaDataObject;
    }

    public static MultipleChoiceQuestion createDummyMultipleChoiceQuestion(int id, int numberOfIncorrectAnswers) {
        String [] incorrectAnswers = new String[numberOfIncorrectAnswers];
        for (int i = 1 ; i < incorrectAnswers.length + 1 ; i++) {
            incorrectAnswers[i - 1] = "Incorrect answer " + i;
        }
        MultipleChoiceQuestion dummyMultipleChoiceQuestion = new MultipleChoiceQuestion();
        dummyMultipleChoiceQuestion.setQuestion("Question " + id);
        dummyMultipleChoiceQuestion.setCategory("Category " + id);
        dummyMultipleChoiceQuestion.setCorrectAnswer("Correct Answer " + id);
        dummyMultipleChoiceQuestion.setIncorrectAnswers(incorrectAnswers);
        dummyMultipleChoiceQuestion.setDifficulty("Difficulty " + id);
        return dummyMultipleChoiceQuestion;
    }

    public static MultipleChoiceQuestion[] createDummyMultipleChoiceQuestions(int amount, int numberOfIncorrectAnswersForEach) {
        MultipleChoiceQuestion[] dummyMultipleChoiceQuestions = new MultipleChoiceQuestion[3];
        for (int i = 1; i < dummyMultipleChoiceQuestions.length + 1 ; i++) {
            dummyMultipleChoiceQuestions[i - 1] = Stubs.createDummyMultipleChoiceQuestion(i, 4);
        }
        return dummyMultipleChoiceQuestions;
    }
}
