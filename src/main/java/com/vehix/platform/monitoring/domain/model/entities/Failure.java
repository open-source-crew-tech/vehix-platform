package com.vehix.platform.monitoring.domain.model.entities;

import com.vehix.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Entity
public class Failure extends AuditableModel {
    @ManyToOne
    @JoinColumn
    @NotNull

}
