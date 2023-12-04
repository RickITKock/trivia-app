package com.example.triviaapprk22applicationv2.controller;

import com.example.triviaapprk22applicationv2.model.Answer;
import com.example.triviaapprk22applicationv2.model.Question;
import com.example.triviaapprk22applicationv2.model.Result;
import com.example.triviaapprk22applicationv2.repository.TriviaAppRepository;
import com.example.triviaapprk22applicationv2.service.TriviaAppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// TODO: Create a list of questions and answers when fetching API data
// TODO: Make sure all tests succeed
// TODO: Refactor code
// TODO: Style the templates

@Controller
public class TriviaAppController {
    private static final String OPENTDB_BASE_URI = "https://opentdb.com/api.php";
    private static final int NUMBER_OF_QUESTIONS = 5;
    private RestTemplate restTemplate;
    private TriviaAppRepository repository;
    private TriviaAppService service;
    private Question[] questions;

    TriviaAppController() {
        this.restTemplate = new RestTemplate();
        this.repository = new TriviaAppRepository(restTemplate);
        this.service = new TriviaAppService(repository);
        String uri = constructFullPathToApi(OPENTDB_BASE_URI, "amount", String.valueOf(NUMBER_OF_QUESTIONS));
        this.questions = this.service.getQuestions(uri);

        for (int i = 0 ; i < questions.length; i++) {
            Question question = questions[i];
            question.prepareAllPossibleAnswers();
            question.setId(i);
        }
    }

    @GetMapping(value = "/questions")
    public String showTriviaApp(Model model) {
        model.addAttribute("questions", this.questions);
        return "questions";
    }

    @PostMapping(value = "/results")
    public String showAnswers(@RequestParam Map<String, String> allParams, Model model) {
        List<Result> results = new ArrayList<>();

        for (Question question : questions) {
            String submittedAnswer = allParams.get("answer" + question.getId());
            System.out.println(question.getId());
            Answer answer = new Answer(question.getCorrectAnswer(), submittedAnswer);
            Result result = new Result(question, answer);
            results.add(result);
        }
        model.addAttribute("results", results);
        return "results";
    }

    private String constructFullPathToApi(String uri, String parameterName, String value) {
        String requestParameter = String.format("?%s=%s", parameterName, value);
        return uri.concat(requestParameter);
    }
}
