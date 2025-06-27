package com.vehix.platform.monitoring.application.queryservices;


import com.vehix.platform.monitoring.domain.model.entities.BadPractice;
import com.vehix.platform.monitoring.domain.model.queries.GetAllBadPracticesQuery;
import com.vehix.platform.monitoring.domain.model.queries.GetBadPracticeByIdQuery;
import com.vehix.platform.monitoring.domain.services.BadPracticeQueryService;
import com.vehix.platform.monitoring.infrastructure.persistence.jpa.repositories.BadPracticeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BadPracticeQueryServiceImpl implements BadPracticeQueryService {

    private final BadPracticeRepository badPracticeRepository;

    public BadPracticeQueryServiceImpl(BadPracticeRepository badPracticeRepository) {
        this.badPracticeRepository = badPracticeRepository;
    }

    @Override
    public Optional<BadPractice> handle(GetBadPracticeByIdQuery query) {
        return badPracticeRepository.findById((long) query.badPracticeId());
    }

    @Override
    public List<BadPractice> handle(GetAllBadPracticesQuery query) {
        return badPracticeRepository.findAll();
    }
}