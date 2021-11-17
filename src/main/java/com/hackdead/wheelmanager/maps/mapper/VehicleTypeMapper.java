package com.hackdead.wheelmanager.maps.mapper;

import com.hackdead.wheelmanager.core.entities.VehicleType;
import com.hackdead.wheelmanager.maps.request.VehicleTypeRequest;

public class VehicleTypeMapper {
    public static VehicleType toVehicleType(VehicleTypeRequest vehicleTypeRequest) {
        VehicleType vehicleType = new VehicleType();
        vehicleType.setTypeName(vehicleTypeRequest.getTypeName());
        return vehicleType;
    }
}
