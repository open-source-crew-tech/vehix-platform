package com.vehix.platform.monitoring.interfaces;

import com.vehix.platform.monitoring.domain.model.entities.BadPractice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BadPracticeRepository extends JpaRepository<BadPractice, Long> {
    Optional<BadPractice> findByDescriptionBadPractice(String descriptionBadPractice);
    boolean existsByDescriptionBadPractice(String descriptionBadPractice);
}
