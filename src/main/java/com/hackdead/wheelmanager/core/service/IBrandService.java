package com.hackdead.wheelmanager.core.service;

import com.hackdead.wheelmanager.core.entities.Brand;

import java.util.List;

public interface IBrandService extends CrudService<Brand> {
    List<Brand> findByBrandName(String brandName);
}
