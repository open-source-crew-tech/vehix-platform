package com.vehix.platform.monitoring.application.eventhandlers;

import com.vehix.platform.monitoring.domain.model.events.BadPracticeCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class BadPracticeCreatedEventHandler {

    @EventListener(BadPracticeCreatedEvent.class)
    public void on(BadPracticeCreatedEvent event) {
        System.out.println("Created Bad Practice: " + event.getDescriptionBadPractice());
    }
}