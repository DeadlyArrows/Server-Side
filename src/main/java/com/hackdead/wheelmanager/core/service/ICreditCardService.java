package com.hackdead.wheelmanager.core.service;

import com.hackdead.wheelmanager.core.entities.CreditCard;
import com.hackdead.wheelmanager.core.service.CrudService;

import java.util.List;

public interface ICreditCardService extends CrudService<CreditCard> {
    List<CreditCard> findCreditCardsByCardNumber(String cardNumber);
}
