package com.vehix.platform.monitoring.application.eventhandlers;

import com.vehix.platform.monitoring.domain.model.events.OdbErrorCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class OdbErrorCreatedEventHandler {

    @EventListener(OdbErrorCreatedEvent.class)
    public void on(OdbErrorCreatedEvent event) {
        System.out.println("Created ODB Error Code: " + event.getErrorCode());
        System.out.println("Created ODB Error Title: " + event.getErrorCodeTitle());
    }
}