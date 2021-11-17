package com.hackdead.wheelmanager.core.service;

import com.hackdead.wheelmanager.core.entities.VehicleType;

import java.util.List;

public interface IVehicleTypeService extends CrudService<VehicleType> {
    List<VehicleType> findByTypeName(String typeName) throws Exception;
}
