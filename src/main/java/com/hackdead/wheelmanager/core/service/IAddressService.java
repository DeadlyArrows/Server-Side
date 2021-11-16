package com.hackdead.wheelmanager.core.service;

import com.hackdead.wheelmanager.core.entities.Address;
import com.hackdead.wheelmanager.core.service.CrudService;

import java.util.List;

public interface IAddressService extends CrudService<Address> {
    List<Address> findByLongitudeAndLatitude(Double longitude, Double latitude) throws Exception;
}
