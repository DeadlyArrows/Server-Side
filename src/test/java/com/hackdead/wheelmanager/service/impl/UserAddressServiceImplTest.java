package com.hackdead.wheelmanager.service.impl;

import com.hackdead.wheelmanager.entities.Address;
import com.hackdead.wheelmanager.entities.Customer;
import com.hackdead.wheelmanager.entities.UserAddress;
import com.hackdead.wheelmanager.repository.IUserAddressRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserAddressServiceImplTest {
    @Mock
    private IUserAddressRepository userAddressRepository;
    @InjectMocks
    private UserAddressServiceImpl userAddressService;

    @Test
    void save() throws Exception {
        UserAddress userAddress = new UserAddress(1L, false, new Customer(),
                new Address());
        given(userAddressRepository.save(userAddress)).willReturn(userAddress);

        UserAddress expected = userAddressService.save(userAddress);
        assertEquals(expected, userAddress);
    }

    @Test
    void delete() throws Exception {
        Long id = 1L;
        userAddressService.delete(id);
        verify(userAddressRepository, times(1)).deleteById(id);
    }

    @Test
    void getAll() throws Exception {
        List<UserAddress> userAddressList = new ArrayList<>();
        userAddressList.add(new UserAddress(1L, false, new Customer(),
                new Address()));
        userAddressList.add(new UserAddress(2L, true, new Customer(),
                new Address()));

        given(userAddressRepository.findAll()).willReturn(userAddressList);

        List<UserAddress> expected = userAddressService.getAll();
        assertEquals(userAddressList, expected);
    }

    @Test
    void getById() throws Exception {
        Long id = 1L;
        UserAddress userAddress = new UserAddress(1L, false, new Customer(),
                new Address());
        given(userAddressRepository.findById(id)).willReturn(Optional.of(userAddress));

        Optional<UserAddress> expected = userAddressService.getById(id);

        assertEquals(userAddress, expected.get());
    }
}