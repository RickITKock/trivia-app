package com.example.triviaapprk22applicationv2.builder;

import com.example.triviaapprk22applicationv2.model.triviadata.MultipleChoiceQuestion;
import com.example.triviaapprk22applicationv2.model.triviadata.PreparedMultipleChoiceQuestion;
import com.example.triviaapprk22applicationv2.stubs.Stubs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static java.util.Arrays.copyOf;
import static org.junit.jupiter.api.Assertions.*;

class TriviaQuizBuilderTest {
    private static final int AMOUNT_OF_QUESTIONS = 3;
    private static final int NUMBER_OF_INCORRECT_ANSWERS_FOR_EACH_QUESTION = 4;
    private MultipleChoiceQuestion[] dummyMultipleChoiceQuestions;
    private TriviaQuizBuilder builderUnderTest;

    @BeforeEach
    void setup() {
        this.dummyMultipleChoiceQuestions = Stubs
                .createDummyMultipleChoiceQuestions(AMOUNT_OF_QUESTIONS, NUMBER_OF_INCORRECT_ANSWERS_FOR_EACH_QUESTION);
        this.builderUnderTest = new TriviaQuizBuilder(this.dummyMultipleChoiceQuestions);
    }

    @Test
    void canPrepareASingleMultipleChoiceQuestion() {
        // Arrange
        MultipleChoiceQuestion dummyMultipleChoiceQuestion = dummyMultipleChoiceQuestions[0];
        // Act
        PreparedMultipleChoiceQuestion preparedMultipleChoiceQuestion = builderUnderTest.getPreparedMultipleChoiceQuestion(dummyMultipleChoiceQuestion);
        // Assert
        assertNotNull(preparedMultipleChoiceQuestion);
    }

    @Test
    void canPrepareAListOfMultipleChoiceQuestions() {
        // Arrange
        // Act
        PreparedMultipleChoiceQuestion[] preparedMultipleChoiceQuestions = builderUnderTest.getPreparedMultipleChoiceQuestions();
        // Assert
        assertEquals(preparedMultipleChoiceQuestions.length, dummyMultipleChoiceQuestions.length);
    }

    @Test
    void numberOfAllPossibleAnswersShouldBeEqualToNumberOfIncorrectAnswersPlusCorrectAnswer() {
        // Arrange
        int numberOfAnswersExpected = NUMBER_OF_INCORRECT_ANSWERS_FOR_EACH_QUESTION + 1;
        PreparedMultipleChoiceQuestion preparedMultipleChoiceQuestion = builderUnderTest
                .getPreparedMultipleChoiceQuestion(dummyMultipleChoiceQuestions[0]);
        // Act
        String[] allPossibleAnswers = preparedMultipleChoiceQuestion.getAllPossibleAnswers();
        // Assert
        assertEquals(numberOfAnswersExpected, allPossibleAnswers.length);
    }

    @Test
    void allPossibleAnswersShouldContainIncorrectAnswersAndCorrectAnswer() {
        // Arrange
        MultipleChoiceQuestion dqStub = dummyMultipleChoiceQuestions[0];
        PreparedMultipleChoiceQuestion preparedMultipleChoiceQuestion = builderUnderTest
                .getPreparedMultipleChoiceQuestion(dqStub);
        String[] incorrectAnswersAndCorrectAnswer = copyOf(dqStub.getIncorrectAnswers(), dqStub.getIncorrectAnswers().length + 1);
        incorrectAnswersAndCorrectAnswer[dqStub.getIncorrectAnswers().length] = dqStub.getCorrectAnswer();

        // Act
        String[] allPossibleAnswers = preparedMultipleChoiceQuestion.getAllPossibleAnswers();
        // Assert
        Arrays.sort(allPossibleAnswers);
        Arrays.sort(incorrectAnswersAndCorrectAnswer);
        assertTrue(Arrays.equals(allPossibleAnswers, incorrectAnswersAndCorrectAnswer));
    }

    @Test
    void allPossibleAnswersAreShuffled() {
        // Arrange
        MultipleChoiceQuestion dqStub = dummyMultipleChoiceQuestions[0];
        PreparedMultipleChoiceQuestion preparedMultipleChoiceQuestion = builderUnderTest
                .getPreparedMultipleChoiceQuestion(dqStub);
        String[] incorrectAnswersAndCorrectAnswer = copyOf(dqStub.getIncorrectAnswers(), dqStub.getIncorrectAnswers().length + 1);
        incorrectAnswersAndCorrectAnswer[dqStub.getIncorrectAnswers().length] = dqStub.getCorrectAnswer();
        // Act
        String[] allPossibleAnswers = preparedMultipleChoiceQuestion.getAllPossibleAnswers();
        // Assert
        assertFalse(arrayElementsAreInSameOrder(incorrectAnswersAndCorrectAnswer, allPossibleAnswers));
    }

    boolean arrayElementsAreInSameOrder(String[] array1, String[] array2) {
        if (array1.length == array2.length) {
            for (int i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }
}