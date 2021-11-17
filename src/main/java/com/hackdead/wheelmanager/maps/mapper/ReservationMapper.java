package com.hackdead.wheelmanager.maps.mapper;

import com.hackdead.wheelmanager.core.entities.Reservation;
import com.hackdead.wheelmanager.maps.request.ReservationRequest;

public class ReservationMapper {
    public static Reservation toReservation(ReservationRequest reservationRequest) {
        Reservation reservation = new Reservation();
        reservation.setStartDate(reservationRequest.getStartDate());
        reservation.setEndDate(reservationRequest.getEndDate());
        reservation.setReservationPrice(reservationRequest.getReservationPrice());
        return reservation;
    }
}
