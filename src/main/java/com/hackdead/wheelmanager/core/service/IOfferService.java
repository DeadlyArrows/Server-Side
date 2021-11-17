package com.hackdead.wheelmanager.core.service;

import com.hackdead.wheelmanager.core.entities.Offer;

import java.util.List;

public interface IOfferService extends CrudService<Offer> {
    List<Offer> findByOfferName(String offerName) throws Exception;
}
