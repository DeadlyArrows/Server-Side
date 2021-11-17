package com.hackdead.wheelmanager.maps.mapper;

import com.hackdead.wheelmanager.core.entities.RentalActivity;
import com.hackdead.wheelmanager.maps.request.RentalActivityRequest;

public class RentalActivityMapper {
    public static RentalActivity toRentalActivity(RentalActivityRequest rentalActivityRequest) {
        RentalActivity rentalActivity = new RentalActivity();
        rentalActivity.setPrice(rentalActivityRequest.getPrice());
        rentalActivity.setCommission(rentalActivityRequest.getCommission());
        rentalActivity.setInsurancePrice(rentalActivityRequest.getInsurancePrice());
        return rentalActivity;
    }
}
