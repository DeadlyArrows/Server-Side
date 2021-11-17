package com.hackdead.wheelmanager.maps.mapper;

import com.hackdead.wheelmanager.core.entities.Brand;
import com.hackdead.wheelmanager.maps.request.BrandRequest;

public class BrandMapper {
    private BrandMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Brand toBrand(BrandRequest brandRequest) {
        Brand brand = new Brand();
        brand.setBrandName(brandRequest.getBrandName());
        return brand;
    }
}
