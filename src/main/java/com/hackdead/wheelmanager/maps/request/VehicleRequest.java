package com.hackdead.wheelmanager.maps.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequest {
    private String vehicleName;
    private String imageUrl;
    private Integer score;
    private String description;
}
