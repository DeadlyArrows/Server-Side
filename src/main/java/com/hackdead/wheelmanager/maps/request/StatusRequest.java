package com.hackdead.wheelmanager.maps.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatusRequest implements Serializable {
    private String statusName;
}
