package com.okta.system.System.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateServiceDto {

    private String name;
    private String description;
}
