package com.example.yemekTarifi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalTime;

@Service
public class TimeService {
    private final WebClient webClient = WebClient.create("http://localhost:8080");

    public Flux<ServerSentEvent<LocalTime>> getTimeUpdates() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> ServerSentEvent.<LocalTime>builder()
                        .event("time")
                        .data(LocalTime.now())
                        .build());
    }


    public void getData(){
        webClient.get().uri("/time")
                .retrieve()
                .bodyToFlux(ServerSentEvent.class)
                .subscribe(sse -> {

                });
    }


    public Flux<String> streamEvents() {
        return webClient
                .get()
                .uri("/data-source")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(String.class);
    }
}