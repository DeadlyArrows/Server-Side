package com.hackdead.wheelmanager.maps.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentalActivityRequest {
    private double price;
    private double commission;
    private double insurancePrice;

}
