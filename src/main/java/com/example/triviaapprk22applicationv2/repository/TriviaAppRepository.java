package com.example.triviaapprk22applicationv2.repository;

import com.example.triviaapprk22applicationv2.model.triviadata.TriviaData;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class TriviaAppRepository {
    private RestTemplate restTemplate;

    public TriviaAppRepository(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public TriviaData fetch(String uri) {
        return restTemplate.getForObject(uri, TriviaData.class);
    }
}
