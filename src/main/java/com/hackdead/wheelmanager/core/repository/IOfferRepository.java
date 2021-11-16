package com.hackdead.wheelmanager.core.repository;

import com.hackdead.wheelmanager.core.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findByOfferName(String offerName);
}
