package com.hackdead.wheelmanager.service;

import com.hackdead.wheelmanager.entities.Offer;
import com.hackdead.wheelmanager.repository.IOfferRepository;
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
class OfferServiceImplTest {
    @Mock
    private IOfferRepository offerRepository;
    @InjectMocks
    private OfferServiceImpl offerService;

    @Test
    void save() throws Exception{
        Offer offer = new Offer(1L, "Oferta", "Nueva oferta", "/434/fds",
                new Date(2010, 12,20),new Date(2011, 12,20), 12.43);

        given(offerRepository.save(offer)).willReturn(offer);

        Offer expected = offerService.save(offer);

        assertThat(offer).isEqualTo(expected);
    }

    @Test
    void delete() throws Exception {
        Long id = 1L;
        offerService.delete(id);
        verify(offerRepository, times(1)).deleteById(id);
    }

    @Test
    void getAll() throws Exception {
        List<Offer> offerList = new ArrayList<>();
        offerList.add(new Offer(1L, "Oferta", "Nueva oferta", "/434/fds",
                new Date(2010, 12,20),new Date(2011, 12,20), 12.43));
        offerList.add(new Offer(2L, "Oferta", "Nueva oferta", "/434/fds",
                new Date(2010, 12,20),new Date(2011, 12,20), 12.43));
        offerList.add(new Offer(3L, "Oferta", "Nueva oferta", "/434/fds",
                new Date(2010, 12,20),new Date(2011, 12,20), 12.43));

        given(offerRepository.findAll()).willReturn(offerList);

        List<Offer> expected = offerService.getAll();
        assertEquals(expected, offerList);
    }

    @Test
    void getById() throws Exception {
        Long id = 1L;
        Offer offer = new Offer(1L, "Oferta", "Nueva oferta", "/434/fds",
                new Date(2010, 12,20),new Date(2011, 12,20), 12.43);
        given(offerRepository.findById(id)).willReturn(Optional.of(offer));

        Optional<Offer> expected = offerService.getById(id);
        assertEquals(expected.get(), offer);
    }

    @Test
    void findByOfferName() throws Exception {
        String offerName = "Oferta Inicial";
        List<Offer> offerList = new ArrayList<>();
        offerList.add(new Offer(1L, "Oferta Inicial", "Nueva oferta", "/434/fds",
                new Date(2010, 12,20),new Date(2011, 12,20), 12.43));

        given(offerRepository.findByOfferName(offerName)).willReturn(offerList);

        List<Offer> expected = offerService.findByOfferName(offerName);

        assertThat(offerList).isEqualTo(expected);
    }
}