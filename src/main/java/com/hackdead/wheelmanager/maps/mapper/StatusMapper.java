package com.hackdead.wheelmanager.maps.mapper;

import com.hackdead.wheelmanager.core.entities.Status;
import com.hackdead.wheelmanager.maps.request.StatusRequest;

public class StatusMapper {
    private StatusMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Status toStatus(StatusRequest statusRequest) {
        Status status = new Status();
        status.setStatusName(statusRequest.getStatusName());
        return status;
    }
}
