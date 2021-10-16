package com.hackdead.wheelmanager.service.impl;

import com.hackdead.wheelmanager.entities.Customer;
import com.hackdead.wheelmanager.entities.Reservation;
import com.hackdead.wheelmanager.entities.Vehicle;
import com.hackdead.wheelmanager.repository.IReservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
class ReservationServiceImplTest {
    @Mock
    private IReservationRepository reservationRepository;
    @InjectMocks
    private ReservationServiceImpl reservationService;

    @Test
    void save() throws Exception {
        Reservation reservation = new Reservation(1L,
                new Date(2010, 12, 10),
                new Date(2010, 12, 11),
                11.29,
                new Customer(), new Vehicle());

        given(reservationRepository.save(reservation)).willReturn(reservation);

        Reservation expected = reservationService.save(reservation);
        assertThat(reservation).isEqualTo(expected);
    }

    @Test
    void delete() throws Exception {
        Long id = 1L;
        reservationService.delete(id);
        verify(reservationRepository, times(1)).deleteById(id);
    }

    @Test
    void getAll() throws Exception {
        List<Reservation> reservations = new ArrayList<>();
        reservations.add(new Reservation(1L,
                new Date(2010, 12, 10),
                new Date(2010, 12, 11),
                11.29,
                new Customer(), new Vehicle()));
        reservations.add(new Reservation(1L,
                new Date(2010, 12, 5),
                new Date(2010, 12, 9),
                11.40,
                new Customer(), new Vehicle()));

        given(reservationRepository.findAll()).willReturn(reservations);

        List<Reservation> expected = reservationService.getAll();
        assertEquals(reservations, expected);
    }

    @Test
    void getById() throws Exception {
        Long id = 1L;
        Reservation reservation = new Reservation(id,
                new Date(2010, 12, 10),
                new Date(2010, 12, 11),
                11.29,
                new Customer(), new Vehicle());

        given(reservationRepository.findById(id)).willReturn(Optional.of(reservation));
        Optional<Reservation> expected = reservationService.getById(id);

        assertThat(reservation).isEqualTo(expected.get());
    }
}