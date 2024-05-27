package com.okta.system.System.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateRoomDto {

    private int nroRoom;
    private String status;
    private int nroBeds;
    private int nroPersons;
    private String size;
    private float price;
    private String description;
    private String type;
    private String view;
}
