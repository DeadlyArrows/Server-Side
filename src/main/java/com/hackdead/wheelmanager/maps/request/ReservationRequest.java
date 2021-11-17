package com.hackdead.wheelmanager.maps.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {
    private Date startDate;
    private Date endDate;
    private Double reservationPrice;
}
