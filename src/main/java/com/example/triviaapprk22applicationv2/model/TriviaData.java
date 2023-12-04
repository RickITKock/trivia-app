package com.example.triviaapprk22applicationv2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TriviaData {
    @JsonProperty("results")
    private Question[] questions;

    public Question[] getMultipleChoiceQuestions() {
        return questions;
    }

    public void setMultipleChoiceQuestions(Question[] questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "TriviaData{" +
                "multipleChoiceQuestions=" + Arrays.toString(questions) +
                '}';
    }
}
