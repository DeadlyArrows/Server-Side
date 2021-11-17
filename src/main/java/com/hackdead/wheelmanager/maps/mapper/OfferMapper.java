package com.hackdead.wheelmanager.maps.mapper;

import com.hackdead.wheelmanager.core.entities.Offer;
import com.hackdead.wheelmanager.maps.request.OfferRequest;

public class OfferMapper {
    private OfferMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static Offer toOffer(OfferRequest offerRequest) {
        Offer offer = new Offer();
        offer.setOfferName(offerRequest.getOfferName());
        offer.setDescription(offerRequest.getDescription());
        offer.setImageUrl(offerRequest.getImageUrl());
        offer.setStartDate(offerRequest.getStartDate());
        offer.setEndDate(offerRequest.getEndDate());
        offer.setOfferPrice(offerRequest.getOfferPrice());
        return offer;
    }
}
