package com.hackdead.wheelmanager.core.service;

import com.hackdead.wheelmanager.core.entities.Vehicle;

import java.util.List;

public interface IVehicleService extends CrudService<Vehicle> {
    List<Vehicle> findByVehicleName(String vehicleName);
}
