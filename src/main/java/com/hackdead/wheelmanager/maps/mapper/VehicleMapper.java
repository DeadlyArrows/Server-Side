package com.hackdead.wheelmanager.maps.mapper;

import com.hackdead.wheelmanager.core.entities.Vehicle;
import com.hackdead.wheelmanager.maps.request.VehicleRequest;

public class VehicleMapper {
    private VehicleMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Vehicle toVehicle(VehicleRequest vehicleRequest) {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName(vehicleRequest.getVehicleName());
        vehicle.setImageUrl(vehicleRequest.getImageUrl());
        vehicle.setScore(vehicleRequest.getScore());
        vehicle.setDescription(vehicleRequest.getDescription());
        return vehicle;
    }
}
