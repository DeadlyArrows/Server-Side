package com.hackdead.wheelmanager.core.service;

import com.hackdead.wheelmanager.core.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService extends CrudService<Customer> {
    List<Customer> findByUsername(String username) throws Exception;

    List<Customer> findByName(String name) throws Exception;

    Optional<Customer> findByDni(String dni) throws Exception;

    Optional<Customer> findByEmailAndPassword(String email, String password) throws Exception;
}
