package com.vehix.platform.monitoring.application.commandservices;

import com.vehix.platform.monitoring.domain.model.commands.CreateOdbErrorCommand;
import com.vehix.platform.monitoring.domain.model.entities.OdbError;
import com.vehix.platform.monitoring.domain.model.events.OdbErrorCreatedEvent;
import com.vehix.platform.monitoring.domain.services.OdbErrorCommandService;
import com.vehix.platform.monitoring.infrastructure.persistence.jpa.repositories.OdbErrorRepository;
import jakarta.transaction.Transactional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OdbErrorCommandServiceImpl implements OdbErrorCommandService {

    private final OdbErrorRepository odbErrorRepository;
    private final ApplicationEventPublisher eventPublisher;

    public OdbErrorCommandServiceImpl(OdbErrorRepository odbErrorRepository,
                                      ApplicationEventPublisher eventPublisher) {
        this.odbErrorRepository = odbErrorRepository;
        this.eventPublisher = eventPublisher;
    }

    @Override
    @Transactional
    public Optional<OdbError> handle(CreateOdbErrorCommand command) {
        var odbError = new OdbError(command);
        odbErrorRepository.save(odbError);

        eventPublisher.publishEvent(
                new OdbErrorCreatedEvent(
                        odbError.getId(),
                        odbError.getErrorCode(),
                        odbError.getErrorCodeTitle()
                )
        );

        return Optional.of(odbError);
    }
}
