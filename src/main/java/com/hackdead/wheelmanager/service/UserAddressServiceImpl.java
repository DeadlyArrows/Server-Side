package com.hackdead.wheelmanager.service;

import com.hackdead.wheelmanager.core.entities.UserAddress;
import com.hackdead.wheelmanager.core.repository.IUserAddressRepository;
import com.hackdead.wheelmanager.core.service.IUserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserAddressServiceImpl implements IUserAddressService {
    @Autowired
    private IUserAddressRepository userAddressRepository;

    @Override
    @Transactional
    public UserAddress save(UserAddress userAddress) throws Exception {
        return userAddressRepository.save(userAddress);
    }

    @Override
    public void delete(Long id) throws Exception {
        userAddressRepository.deleteById(id);
    }

    @Override
    public List<UserAddress> getAll() throws Exception {
        return userAddressRepository.findAll();
    }

    @Override
    public Optional<UserAddress> getById(Long id) throws Exception {
        return userAddressRepository.findById(id);
    }
}
