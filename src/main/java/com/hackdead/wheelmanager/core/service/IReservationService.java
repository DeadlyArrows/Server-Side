package com.hackdead.wheelmanager.core.service;

import com.hackdead.wheelmanager.core.entities.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService extends CrudService<Reservation> {
    List<Reservation> findBetweenDate(Date startDate, Date endDate) throws Exception;

    List<Reservation> findReservationByVehicleId(Long vehicleId) throws Exception;
}
