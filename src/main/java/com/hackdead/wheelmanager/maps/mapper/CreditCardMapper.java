package com.hackdead.wheelmanager.maps.mapper;

import com.hackdead.wheelmanager.core.entities.CreditCard;
import com.hackdead.wheelmanager.maps.request.CreditCardRequest;

public class CreditCardMapper {
    private CreditCardMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static CreditCard toCreditCard(CreditCardRequest creditCardRequest) {
        CreditCard creditCard = new CreditCard();
        creditCard.setCardNumber(creditCardRequest.getCardNumber());
        creditCard.setExpirationDate(creditCardRequest.getExpirationDate());
        creditCard.setCardCvv(creditCardRequest.getCardCvv());
        return creditCard;
    }
}
