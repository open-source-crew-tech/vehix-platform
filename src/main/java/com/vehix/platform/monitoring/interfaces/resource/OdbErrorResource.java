package com.vehix.platform.monitoring.interfaces.resource;

public record OdbErrorResource(int id, String errorCode, String errorTitle, String errorType) {
    public OdbErrorResource(Long id, String errorCode, String errorCodeTitle, String string) {
        this(id.intValue(), errorCode, errorCodeTitle, string);
    }
}
