package com.vehix.platform.monitoring.application.commandservices;

import com.vehix.platform.monitoring.domain.model.commands.CreateBadPracticeCommand;
import com.vehix.platform.monitoring.domain.model.entities.BadPractice;
import com.vehix.platform.monitoring.domain.services.BadPracticeCommandService;
import com.vehix.platform.monitoring.infrastructure.persistence.jpa.repositories.BadPracticeRepository;
import org.springframework.stereotype.Service;

@Service
public class BadPracticeCommandServiceImpl implements BadPracticeCommandService {
    private final BadPracticeRepository badPracticeRepository;

    public BadPracticeCommandServiceImpl(BadPracticeRepository badPracticeRepository) {
        this.badPracticeRepository = badPracticeRepository;
    }

    @Override
    public BadPractice handle(CreateBadPracticeCommand command) {
        if(badPracticeRepository.existsByDescriptionBadPractice(command.descriptionBadPractice()))
            throw new IllegalArgumentException("BadPractice already exists");
        var badPractice = new BadPractice(command);
        try {
            badPracticeRepository.save(badPractice);
        } catch (Exception e) {
            throw new RuntimeException("Error saving BadPractice: " + e.getMessage(), e);
        }
        return badPractice;
    }

    private void verifyIfBadPracticeExistsById(Long badPracticeId) {
        if(!badPracticeRepository.existsById(badPracticeId))
            throw new IllegalArgumentException("BadPractice not found with id: " + badPracticeId);
    }
}
