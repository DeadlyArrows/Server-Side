package com.hackdead.wheelmanager.maps.mapper;

import com.hackdead.wheelmanager.core.entities.UserAddress;

public class UserAddressMapper {
    public static UserAddress toUserAddress() {
        UserAddress userAddress = new UserAddress();
        userAddress.setSelected(userAddress.isSelected());
        return userAddress;
    }
}
