package com.example.triviaapprk22applicationv2.controller;

import com.example.triviaapprk22applicationv2.builder.TriviaQuizBuilder;
import com.example.triviaapprk22applicationv2.model.triviadata.MultipleChoiceQuestion;
import com.example.triviaapprk22applicationv2.model.triviadata.PreparedMultipleChoiceQuestion;
import com.example.triviaapprk22applicationv2.repository.TriviaAppRepository;
import com.example.triviaapprk22applicationv2.service.TriviaAppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
public class TriviaAppController {
    private static final String OPENTDB_BASE_URI = "https://opentdb.com/api.php";
    private static final int NUMBER_OF_QUESTIONS = 5;
    private RestTemplate restTemplate;
    private TriviaAppRepository repository;
    private TriviaAppService service;
    private MultipleChoiceQuestion[] multipleChoiceQuestions;
    private TriviaQuizBuilder builder;

    TriviaAppController() {
        this.restTemplate = new RestTemplate();
        this.repository = new TriviaAppRepository(restTemplate);
        this.service = new TriviaAppService(repository);
        String uri = constructFullPathToApi(OPENTDB_BASE_URI, "amount", String.valueOf(NUMBER_OF_QUESTIONS));
        this.multipleChoiceQuestions = this.service.getQuestions(uri);
        this.builder = new TriviaQuizBuilder(this.multipleChoiceQuestions);
        for (PreparedMultipleChoiceQuestion question : builder.getPreparedMultipleChoiceQuestions()) {
            System.out.println(question.toString());
        }
    }

    @GetMapping(value = "/questions")
    public String showTriviaApp(Model model) {
        model.addAttribute("questions", this.builder);
        return "questions";
    }

    @PostMapping(value = "/answers")
    public String showAnswers(@RequestParam Map<String, String> allParams, Model model) {
        PreparedMultipleChoiceQuestion[] questions = builder.getPreparedMultipleChoiceQuestions();

        // Go through each question and check which have been correctly answered

        // Create an object that hold the information we need to represent in view
        // The object contains:
        // - a list of questions with the question,
        // - the correct answer,
        // - the submitted answer
        // - and a boolean to indicate if the submitted answer is correct or not

        for (PreparedMultipleChoiceQuestion question : questions) {
            String correctAnswer = question.getCorrectAnswer();
            // Assuming allParams is a Map<String, String>
            String submittedAnswer = allParams.get("answer" + question.getId()); // Assuming each question has an ID
            submittedAnswer = submittedAnswer != null ? submittedAnswer.trim() : "";

            System.out.println("Correct answer:\t" + correctAnswer);
            System.out.println("Submitted answer:\t" + submittedAnswer);

            // Compare the correct answer to the submitted answer
            boolean isCorrect = correctAnswer.trim().equalsIgnoreCase(submittedAnswer);
            System.out.println("Answer is " + (isCorrect ? "correct" : "incorrect"));
        }


        return "answers";
    }

    private String constructFullPathToApi(String uri, String parameterName, String value) {
        String requestParameter = String.format("?%s=%s", parameterName, value);
        return uri.concat(requestParameter);
    }
}
