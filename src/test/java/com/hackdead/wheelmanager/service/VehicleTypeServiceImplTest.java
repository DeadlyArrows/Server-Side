package com.hackdead.wheelmanager.service;

import com.hackdead.wheelmanager.entities.*;
import com.hackdead.wheelmanager.repository.IVehicleTypeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VehicleTypeServiceImplTest {
    @Mock
    private IVehicleTypeRepository vehicleTypeRepository;
    @InjectMocks
    private VehicleTypeServiceImpl vehicleTypeService;

    @Test
    void save() throws Exception {
        VehicleType vehicleType = new VehicleType(1L, "No motorizado");
        given(vehicleTypeRepository.save(vehicleType)).willReturn(vehicleType);

        VehicleType expected = vehicleTypeService.save(vehicleType);

        assertEquals(expected, vehicleType);
    }

    @Test
    void delete() throws Exception {
        Long id = 1L;
        vehicleTypeService.delete(id);
        verify(vehicleTypeRepository, times(1)).deleteById(id);
    }

    @Test
    void getAll() throws Exception {
        List<VehicleType> vehicleTypeList = new ArrayList<>();
        vehicleTypeList.add(new VehicleType(1L, "No motorizado"));
        vehicleTypeList.add(new VehicleType(2L, "No motorizado"));

        given(vehicleTypeRepository.findAll()).willReturn(vehicleTypeList);

        List<VehicleType> expected = vehicleTypeService.getAll();

        assertEquals(vehicleTypeList, expected);
    }

    @Test
    void getById() throws Exception {
        Long id = 1L;
        VehicleType vehicleType = new VehicleType(1L, "No motorizado");
        given(vehicleTypeRepository.findById(id)).willReturn(Optional.of(vehicleType));

        Optional<VehicleType> expected = vehicleTypeService.getById(id);
        assertEquals(vehicleType, expected.get());
    }

    @Test
    void findByTypeName() throws Exception {
        String vehicleTypeName = "No motorizado";
        VehicleType vehicleType = new VehicleType(1L, "No motorizado");
        List<VehicleType> vehicleTypeList = new ArrayList<>();
        vehicleTypeList.add(vehicleType);

        given(vehicleTypeRepository.findByTypeName(vehicleTypeName)).willReturn(vehicleTypeList);

        List<VehicleType> expected = vehicleTypeService.findByTypeName(vehicleTypeName);

        assertThat(vehicleTypeList).isEqualTo(expected);
    }
}