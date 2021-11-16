package com.hackdead.wheelmanager.core.service;

import com.hackdead.wheelmanager.core.entities.VehicleType;
import com.hackdead.wheelmanager.core.service.CrudService;

import java.util.List;

public interface IVehicleTypeService extends CrudService<VehicleType> {
    List<VehicleType> findByTypeName(String typeName) throws Exception;
}
