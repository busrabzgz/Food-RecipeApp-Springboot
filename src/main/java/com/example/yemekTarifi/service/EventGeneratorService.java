package com.example.yemekTarifi.service;

import com.example.yemekTarifi.controller.EventController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Service
public class EventGeneratorService {
    private final EventController eventController;

    public EventGeneratorService(EventController eventController) {
        this.eventController = eventController;
    }

    public void start() {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> {
            String event = generateEvent();
            eventController.sendEvent(event);
        }, 0, 1, TimeUnit.SECONDS);
    }

    private String generateEvent() {
        // Generate event data here...
        return "Event data";
    }
}

