package com.hackdead.wheelmanager.core.service;

import com.hackdead.wheelmanager.core.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService extends CrudService<Customer> {
    List<Customer> findByUsername(String username);

    List<Customer> findByName(String name);

    Optional<Customer> findByDni(String dni);

    Optional<Customer> findByEmailAndPassword(String email, String password);
}
