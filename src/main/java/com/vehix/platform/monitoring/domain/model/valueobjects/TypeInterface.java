package com.vehix.platform.monitoring.domain.model.valueobjects;

/**
 * Interface for changing the type of a failure.
 * @summary
 * This interface defines methods for changing the type of a failure.
 * The type represents the category of failure, such as whether it is simple, technical, or caused by bad practices.
 * @since 1.0.0
 */
public interface TypeInterface {
    void changeToSimple();
    void changeToTechnical();
    void changeToBadPractice();
}
