package com.vehix.platform.monitoring.interfaces.resource;

public record CreateFailureResource(String suggestSolution, int badPracticeId, int obdErrorId) {
}
