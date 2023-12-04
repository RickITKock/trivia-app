package com.example.triviaapprk22applicationv2.stubs;

import com.example.triviaapprk22applicationv2.model.TriviaData;
import com.example.triviaapprk22applicationv2.model.Question;

public class Stubs {
    public static TriviaData createDummyTriviaDataObject(Question[] questionsArray) {
        TriviaData dummyTriviaDataObject = new TriviaData();
        dummyTriviaDataObject.setMultipleChoiceQuestions(questionsArray);
        return dummyTriviaDataObject;
    }

    public static Question createDummyMultipleChoiceQuestion(int id, int numberOfIncorrectAnswers) {
        String [] incorrectAnswers = new String[numberOfIncorrectAnswers];
        for (int i = 1 ; i < incorrectAnswers.length + 1 ; i++) {
            incorrectAnswers[i - 1] = "Incorrect answer " + i;
        }
        Question dummyQuestion = new Question();
         dummyQuestion.setQuestion("Question " + id);
        dummyQuestion.setCategory("Category " + id);
        dummyQuestion.setCorrectAnswer("Correct Answer " + id);
        dummyQuestion.setIncorrectAnswers(incorrectAnswers);
        dummyQuestion.setDifficulty("Difficulty " + id);
        return dummyQuestion;
    }

    public static Question[] createDummyMultipleChoiceQuestions(int amount, int numberOfIncorrectAnswersForEach) {
        Question[] dummyQuestions = new Question[3];
        for (int i = 1; i < dummyQuestions.length + 1 ; i++) {
            dummyQuestions[i - 1] = Stubs.createDummyMultipleChoiceQuestion(i, 4);
        }
        return dummyQuestions;
    }
}
