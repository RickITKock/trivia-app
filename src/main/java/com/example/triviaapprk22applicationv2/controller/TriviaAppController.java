package com.example.triviaapprk22applicationv2.controller;

import com.example.triviaapprk22applicationv2.builder.TriviaQuizBuilder;
import com.example.triviaapprk22applicationv2.model.triviadata.MultipleChoiceQuestion;
import com.example.triviaapprk22applicationv2.model.triviadata.PreparedMultipleChoiceQuestion;
import com.example.triviaapprk22applicationv2.repository.TriviaAppRepository;
import com.example.triviaapprk22applicationv2.service.TriviaAppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

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
        return "questions";
    }

    private String constructFullPathToApi(String uri, String parameterName, String value) {
        String requestParameter = String.format("?%s=%s", parameterName, value);
        return uri.concat(requestParameter);
    }
}
