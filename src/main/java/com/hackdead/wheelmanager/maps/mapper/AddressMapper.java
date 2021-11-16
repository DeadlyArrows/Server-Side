package com.hackdead.wheelmanager.maps.mapper;

import com.hackdead.wheelmanager.core.entities.Address;
import com.hackdead.wheelmanager.maps.request.AddressRequest;

public class AddressMapper {
    public static Address toAddress(AddressRequest addressRequest) {
        Address address = new Address();
        address.setLatitude(addressRequest.getLatitude());
        address.setLongitude(addressRequest.getLongitude());
        address.setDescription(addressRequest.getDescription());
        return address;
    }
}
