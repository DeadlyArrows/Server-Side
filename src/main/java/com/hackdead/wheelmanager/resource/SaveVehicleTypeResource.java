package com.hackdead.wheelmanager.resource;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Data
public class SaveVehicleTypeResource {
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String typeName;
}
