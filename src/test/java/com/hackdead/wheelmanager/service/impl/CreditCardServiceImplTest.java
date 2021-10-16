package com.hackdead.wheelmanager.service.impl;

import com.hackdead.wheelmanager.entities.CreditCard;
import com.hackdead.wheelmanager.entities.Customer;
import com.hackdead.wheelmanager.repository.ICreditCardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreditCardServiceImplTest {
    @Mock
    private ICreditCardRepository creditCardRepository;
    @InjectMocks
    private CreditCardServiceImpl creditCardService;

    @Test
    void save() throws Exception{
        CreditCard expected = new CreditCard(1L, "56348309304",
                new Date(2020, 11, 20),
                "743", new Customer());

        given(creditCardRepository.save(expected)).willReturn(expected);

        CreditCard creditCard = creditCardService.save(expected);

        assertThat(creditCard).isEqualTo(expected);
    }

    @Test
    void delete() throws Exception{
        Long id = 1L;
        creditCardService.delete(id);
        verify(creditCardRepository, times(1)).deleteById(id);
    }

    @Test
    void getAll() throws Exception{
        List<CreditCard> creditCardList = new ArrayList<>();
        creditCardList.add(new CreditCard(1L, "23749305", new Date(),
                "343", new Customer()));
        creditCardList.add(new CreditCard(2L, "23749305", new Date(),
                "343", new Customer()));
        creditCardList.add(new CreditCard(3L, "23749305", new Date(),
                "343", new Customer()));

        given(creditCardRepository.findAll()).willReturn(creditCardList);

        List<CreditCard> expected = creditCardService.getAll();

        assertEquals(expected, creditCardList);
    }

    @Test
    void getById() throws Exception{
        Long id = 1L;
        CreditCard creditCard = new CreditCard(id, "23749305", new Date(),
                "343", new Customer());
        given(creditCardRepository.findById(id)).willReturn(Optional.of(creditCard));

        Optional<CreditCard> expected = creditCardService.getById(id);

        assertThat(creditCard).isEqualTo(expected.get());
    }

    @Test
    void findCreditCardsByCardNumber() throws Exception{
        String cardNumber = "23749305";
        CreditCard creditCard = new CreditCard(1L, cardNumber, new Date(),
                "343", new Customer());
        List<CreditCard> creditCardList = new ArrayList<>();
        creditCardList.add(creditCard);

        given(creditCardRepository.findCreditCardsByCardNumber(cardNumber)).willReturn(creditCardList);

        List<CreditCard> expected = creditCardService.findCreditCardsByCardNumber(cardNumber);

        assertThat(creditCardList).isEqualTo(expected);
    }
}