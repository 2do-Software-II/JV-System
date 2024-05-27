package com.okta.system.System.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateRoomServiceDto {
    private String room;
    private String service;
}
