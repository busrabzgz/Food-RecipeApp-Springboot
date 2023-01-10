package com.example.yemekTarifi.controller;

import com.example.yemekTarifi.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/sse")
public class EventController {
    @GetMapping("/events")
    public ResponseBodyEmitter  handleSSE() {
        ResponseBodyEmitter emitter = new ResponseBodyEmitter();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    emitter.send(String.format("Event %d", i));
                    Thread.sleep(1000);
                } catch (Exception ex) {
                    emitter.completeWithError(ex);
                    return;
                }
            }
            emitter.complete();
        });

        return emitter;
    }


    private final SseEmitter sseEmitter = new SseEmitter();

    public void sendEvent(String event) {
        try {
            sseEmitter.send(event);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    private final WebClient webClient = WebClient.create("http://localhost:8080");

    @GetMapping("/sse/eventsClient")
    public Flux<ServerSentEvent<String>> handleSSEClient() {
        return webClient
                .get()
                .uri("/data-source")
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(String.class)
                .map(data -> ServerSentEvent.<String>builder().data(data).build());
    }

    @Autowired
    private TimeService timeService;

    @GetMapping("/time")
    public Flux<ServerSentEvent<LocalTime>> sendTimePeriodically() {
        return timeService.getTimeUpdates();
    }

 
}
