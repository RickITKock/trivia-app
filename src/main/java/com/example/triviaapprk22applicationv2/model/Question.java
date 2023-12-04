package com.example.triviaapprk22applicationv2.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
    private UUID id = UUID.randomUUID();
    private String category;
    private String type;
    private String difficulty;
    private String question;
    @JsonProperty("incorrect_answers")
    private String[] incorrectAnswers;
    @JsonProperty("correct_answer")
    private String correctAnswer;

    private ArrayList<String> allPossibleAnswers;

    public Question() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String[] getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(String[] incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public UUID getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public ArrayList<String> getAllPossibleAnswers() {
        return allPossibleAnswers;
    }

    public void prepareAllPossibleAnswers() {
        ArrayList<String> shuffledAnswers = new ArrayList<>(Arrays.asList(incorrectAnswers));
        shuffledAnswers.add(correctAnswer);
        Collections.shuffle(shuffledAnswers, new Random());
        this.allPossibleAnswers = shuffledAnswers;
    }

    @Override
    public String toString() {
        return "MultipleChoiceQuestion{" +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", question='" + question + '\'' +
                ", incorrectAnswers=" + Arrays.toString(incorrectAnswers) +
                ", correctAnswer='" + correctAnswer + '\'' +
                '}';
    }
}