package com.hackdead.wheelmanager.maps.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferRequest implements Serializable {

    private String offerName;
    private String description;
    private String imageUrl;
    private Date startDate;
    private Date endDate;
    private Double offerPrice;
}
