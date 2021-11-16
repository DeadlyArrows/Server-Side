package com.hackdead.wheelmanager.core.repository;

import com.hackdead.wheelmanager.core.entities.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICreditCardRepository extends JpaRepository<CreditCard, Long> {
    List<CreditCard> findCreditCardsByCardNumber(String cardNumber);
}
