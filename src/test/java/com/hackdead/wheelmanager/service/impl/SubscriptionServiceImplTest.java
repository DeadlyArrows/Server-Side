package com.hackdead.wheelmanager.service.impl;

import com.hackdead.wheelmanager.entities.Comment;
import com.hackdead.wheelmanager.entities.Customer;
import com.hackdead.wheelmanager.entities.Subscription;
import com.hackdead.wheelmanager.repository.ISubscriptionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SubscriptionServiceImplTest {
    @Mock
    private ISubscriptionRepository subscriptionRepository;
    @InjectMocks
    private SubscriptionServiceImpl subscriptionService;

    @Test
    void save() throws Exception {
        Subscription sub = new Subscription(1L, 10.90, "Suscripcion", new Date(), new Customer());
        given(subscriptionRepository.save(sub)).willReturn(sub);

        Subscription expected = subscriptionService.save(sub);
        assertThat(sub).isEqualTo(expected);
    }

    @Test
    void delete() throws Exception {
        Long id = 1L;
        subscriptionService.delete(id);
        verify(subscriptionRepository, times(1)).deleteById(id);
    }

    @Test
    void getAll() throws Exception {
        List<Subscription> subscriptionList = new ArrayList<>();
        subscriptionList.add(new Subscription(1L, 10.90,
                "Suscripcion", new Date(), new Customer()));
        subscriptionList.add(new Subscription(2L, 10.90,
                "Suscripcion", new Date(), new Customer()));
        subscriptionList.add(new Subscription(3L, 10.90,
                "Suscripcion", new Date(), new Customer()));
        given(subscriptionRepository.findAll()).willReturn(subscriptionList);

        List<Subscription> expected = subscriptionService.getAll();
        assertEquals(expected, subscriptionList);
    }

    @Test
    void getById() throws Exception {
        Long id = 1L;
        Subscription sub = new Subscription(1L, 10.90, "Suscripcion", new Date(), new Customer());
        given(subscriptionRepository.findById(id)).willReturn(Optional.of(sub));

        Optional<Subscription> expected = subscriptionService.getById(id);
        assertEquals(expected.get(), sub);
    }
}