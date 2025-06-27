package com.vehix.platform.monitoring.application.commandservices;

import com.vehix.platform.monitoring.domain.model.aggregates.Failure;
import com.vehix.platform.monitoring.domain.model.commands.AddBadPracticeToFailureCommand;
import com.vehix.platform.monitoring.domain.model.commands.AddOdbErrorToFailureCommand;
import com.vehix.platform.monitoring.domain.model.commands.CreateFailureCommand;
import com.vehix.platform.monitoring.domain.model.entities.BadPractice;
import com.vehix.platform.monitoring.domain.model.entities.OdbError;
import com.vehix.platform.monitoring.domain.services.FailureCommandService;
import com.vehix.platform.monitoring.infrastructure.persistence.jpa.repositories.BadPracticeRepository;
import com.vehix.platform.monitoring.infrastructure.persistence.jpa.repositories.FailureRepository;
import com.vehix.platform.monitoring.infrastructure.persistence.jpa.repositories.OdbErrorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FailureCommandServiceImpl implements FailureCommandService {

    private final FailureRepository failureRepository;
    private final BadPracticeRepository badPracticeRepository;
    private final OdbErrorRepository odbErrorRepository;

    public FailureCommandServiceImpl(FailureRepository failureRepository,
                                     BadPracticeRepository badPracticeRepository,
                                     OdbErrorRepository odbErrorRepository) {
        this.failureRepository = failureRepository;
        this.badPracticeRepository = badPracticeRepository;
        this.odbErrorRepository = odbErrorRepository;
    }

    @Override
    @Transactional
    public Optional<Failure> handle(CreateFailureCommand command) {
        BadPractice badPractice = badPracticeRepository.findById((long) command.badPracticeId())
                .orElseThrow(() -> new IllegalArgumentException("Bad practice not found"));

        OdbError odbError = odbErrorRepository.findById((long) command.odbErrorId())
                .orElseThrow(() -> new IllegalArgumentException("Odb error not found"));

        Failure failure = new Failure(command);
        failureRepository.save(failure);

        failure.setBadPractice(badPractice.getDescriptionBadPractice());
        failure.setOdbError(odbError.getErrorCode());

        return Optional.of(failure);
    }

    @Override
    @Transactional
    public Optional<Failure> handle(AddBadPracticeToFailureCommand command) {
        Failure failure = failureRepository.findById((long) command.failureId())
                .orElseThrow(() -> new IllegalArgumentException("Failure not found"));

        failure.addBadPracticeToFailure(command.descriptionBadPractice());
        failureRepository.save(failure);

        return Optional.of(failure);
    }

    @Override
    @Transactional
    public Optional<Failure> handle(AddOdbErrorToFailureCommand command) {
        Failure failure = failureRepository.findById((long) command.failureId())
                .orElseThrow(() -> new IllegalArgumentException("Failure not found"));

        failure.addOdbErrorToFailure(command.errorType());
        failureRepository.save(failure);

        return Optional.of(failure);
    }
}