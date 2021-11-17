package com.hackdead.wheelmanager.service;

import com.hackdead.wheelmanager.core.entities.Offer;
import com.hackdead.wheelmanager.core.entities.RentalActivity;
import com.hackdead.wheelmanager.core.entities.Reservation;
import com.hackdead.wheelmanager.core.repository.IRentalActivityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RentalActivityServiceImplTest {
    @Mock
    private IRentalActivityRepository raRepository;
    @InjectMocks
    private RentalActivityServiceImpl raService;

    @Test
    void save() throws Exception {
        RentalActivity ra = new RentalActivity(1L, 20.4, 0.75, 0.10,
                new Reservation(), new Offer());
        given(raRepository.save(ra)).willReturn(ra);

        RentalActivity expected = raService.save(ra);
        assertThat(ra).isEqualTo(expected);
    }

    @Test
    void delete() throws Exception {
        Long id = 1L;
        raService.delete(id);
        verify(raRepository, times(1)).deleteById(id);
    }

    @Test
    void getAll() throws Exception {
        List<RentalActivity> rentalActivities = new ArrayList<>();
        rentalActivities.add(new RentalActivity(1L, 20.4, 0.75, 0.10,
                new Reservation(), new Offer()));
        rentalActivities.add(new RentalActivity(2L, 20.4, 0.75, 0.10,
                new Reservation(), new Offer()));
        rentalActivities.add(new RentalActivity(3L, 20.4, 0.75, 0.10,
                new Reservation(), new Offer()));

        given(raRepository.findAll()).willReturn(rentalActivities);

        List<RentalActivity> expected = raService.getAll();
        assertEquals(expected, rentalActivities);
    }

    @Test
    void getById() throws Exception {
        Long id = 1L;
        RentalActivity ra = new RentalActivity(id, 20.4, 0.75, 0.10,
                new Reservation(), new Offer());
        given(raRepository.findById(id)).willReturn(Optional.of(ra));

        Optional<RentalActivity> expected = raService.getById(id);
        assertThat(expected).isNotNull();
    }
}