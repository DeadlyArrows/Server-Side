package com.hackdead.wheelmanager.maps.mapper;

import com.hackdead.wheelmanager.core.entities.UserAddress;
import com.hackdead.wheelmanager.maps.request.UserAddressRequest;

public class UserAddressMapper {
    private UserAddressMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static UserAddress toUserAddress(UserAddressRequest userAddressRequest) {
        UserAddress userAddress = new UserAddress();
        userAddress.setSelected(userAddressRequest.isSelected());
        return userAddress;
    }
}
