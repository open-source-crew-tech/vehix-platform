package com.vehix.platform.monitoring.domain.services;

import com.vehix.platform.monitoring.domain.model.entities.BadPractice;
import com.vehix.platform.monitoring.domain.model.queries.GetAllBadPracticesQuery;
import com.vehix.platform.monitoring.domain.model.queries.GetBadPracticeByIdQuery;

import java.util.List;
import java.util.Optional;

public interface BadPracticeQueryService {
    Optional<BadPractice> handle(GetBadPracticeByIdQuery query);
    List<BadPractice> handle(GetAllBadPracticesQuery query);
}
