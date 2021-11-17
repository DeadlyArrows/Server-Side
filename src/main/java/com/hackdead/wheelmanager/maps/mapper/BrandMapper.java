package com.hackdead.wheelmanager.maps.mapper;

import com.hackdead.wheelmanager.core.entities.Brand;
import com.hackdead.wheelmanager.maps.request.BrandRequest;

public class BrandMapper {
    public static Brand toBrand(BrandRequest brandRequest) {
        Brand brand = new Brand();
        brand.setBrandName(brandRequest.getBrandName());
        return brand;
    }
}
