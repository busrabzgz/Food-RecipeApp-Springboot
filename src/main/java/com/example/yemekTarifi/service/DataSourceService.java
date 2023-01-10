package com.example.yemekTarifi.service;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class DataSourceService {
    private final WebClient webClient = WebClient.create("http://localhost:8080");

    public Flux<String> streamEvents() {
        return webClient
                .get()
                .uri("/data-source")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(String.class);
    }
}

