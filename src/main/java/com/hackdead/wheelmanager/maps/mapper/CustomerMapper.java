package com.hackdead.wheelmanager.maps.mapper;

import com.hackdead.wheelmanager.core.entities.Customer;
import com.hackdead.wheelmanager.maps.request.CustomerRequest;

public class CustomerMapper {
    public static Customer toCustomer(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setUsername(customerRequest.getUsername());
        customer.setPassword(customerRequest.getPassword());
        customer.setEmail(customerRequest.getEmail());
        customer.setName(customerRequest.getName());
        customer.setLastName(customerRequest.getLastName());
        customer.setImageUrl(customerRequest.getImageUrl());
        customer.setDni(customerRequest.getDni());
        customer.setGender(customerRequest.getGender());
        customer.setBirthDay(customerRequest.getBirthDay());
        return customer;
    }
}
