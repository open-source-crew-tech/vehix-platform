package com.vehix.platform.monitoring.interfaces.resource;

public record FailureResource(Long id, String suggestSolution, Object badPractice, OdbErrorResource odbError, String failureStatus, String failureType, String failureUrgency) {
}