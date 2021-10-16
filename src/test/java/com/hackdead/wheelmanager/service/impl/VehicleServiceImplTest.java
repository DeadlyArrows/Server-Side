package com.hackdead.wheelmanager.service.impl;

import com.hackdead.wheelmanager.entities.*;
import com.hackdead.wheelmanager.repository.IVehicleRepository;
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
class VehicleServiceImplTest {
    @Mock
    private IVehicleRepository vehicleRepository;
    @InjectMocks
    private  VehicleServiceImpl vehicleService;

    @Test
    void save() throws Exception {
        Vehicle vehicle = new Vehicle(1L, "Patineta", "/434/dfa", 1, "Description",
                new Customer(),
                new Brand(), new Status(), new VehicleType());
        given(vehicleRepository.save(vehicle)).willReturn(vehicle);

        Vehicle expected = vehicleService.save(vehicle);

        assertEquals(expected, vehicle);
    }

    @Test
    void delete() throws Exception {
        Long id = 1L;
        vehicleService.delete(id);
        verify(vehicleRepository, times(1)).deleteById(id);
    }

    @Test
    void getAll() throws Exception {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(1L, "Patineta", "/434/dfa", 1, "Description",
                new Customer(),
                new Brand(), new Status(), new VehicleType()));
        vehicles.add(new Vehicle(2L, "Patineta", "/434/dfa", 1, "Description",
                new Customer(),
                new Brand(), new Status(), new VehicleType()));
        vehicles.add(new Vehicle(3L, "Patineta", "/434/dfa", 1, "Description",
                new Customer(),
                new Brand(), new Status(), new VehicleType()));

        given(vehicleRepository.findAll()).willReturn(vehicles);

        List<Vehicle> expected = vehicleService.getAll();

        assertEquals(expected, vehicles);
    }

    @Test
    void getById() throws Exception {
        Long id = 1L;
        Vehicle vehicle = new Vehicle(2L, "Patineta", "/434/dfa", 1, "Description",
                new Customer(),
                new Brand(), new Status(), new VehicleType());
        given(vehicleRepository.findById(id)).willReturn(Optional.of(vehicle));

        Optional<Vehicle> expected = vehicleService.getById(id);
        assertThat(expected.get()).isEqualTo(vehicle);
    }

    @Test
    void findByVehicleName() {
        String vehicleName = "Patineta";
        Vehicle vehicle = new Vehicle(2L, "Patineta", "/434/dfa", 1, "Description",
                new Customer(),
                new Brand(), new Status(), new VehicleType());
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(vehicle);

        given(vehicleRepository.findByVehicleName(vehicleName)).willReturn(vehicleList);

        List<Vehicle> expected = vehicleService.findByVehicleName(vehicleName);

        assertThat(vehicleList).isEqualTo(expected);
    }
}