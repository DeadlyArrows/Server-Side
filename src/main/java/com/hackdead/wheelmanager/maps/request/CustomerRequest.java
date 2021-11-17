package com.hackdead.wheelmanager.maps.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest implements Serializable {
    private String username;
    private String password;
    private String email;
    private String name;
    private String lastName;
    private String imageUrl;
    private String dni;
    private String gender;
    private Date birthDay;
}
