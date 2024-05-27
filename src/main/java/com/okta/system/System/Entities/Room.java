package com.okta.system.System.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.okta.system.System.Dtos.CreateRoomDto;
import com.okta.system.System.Dtos.UpdateRoomDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "room")
public class Room {

    @Id
    private String id;
    private int nroRoom;
    private String status;
    private int nroBeds;
    private int nroPersons;
    private String size;
    private float price;
    private String description;
    private String type;
    private String view;

    public Room() {
    }

    public Room(int nroRoom, String status, int nroBeds, int nroPersons, String size, int price, String description,
            String type, String view) {
        this.nroRoom = nroRoom;
        this.status = status;
        this.nroBeds = nroBeds;
        this.nroPersons = nroPersons;
        this.size = size;
        this.price = price;
        this.description = description;
        this.type = type;
        this.view = view;
    }

    public Room(CreateRoomDto createRoomDto) {
        this.nroRoom = createRoomDto.getNroRoom();
        this.status = createRoomDto.getStatus();
        this.nroBeds = createRoomDto.getNroBeds();
        this.nroPersons = createRoomDto.getNroPersons();
        this.size = createRoomDto.getSize();
        this.price = createRoomDto.getPrice();
        this.description = createRoomDto.getDescription();
        this.type = createRoomDto.getType();
        this.view = createRoomDto.getView();
    }

    public void update(UpdateRoomDto updateRoomDto) {
        if (updateRoomDto.getNroRoom() != 0)
            this.nroRoom = updateRoomDto.getNroRoom();
        if (updateRoomDto.getStatus() != null)
            this.status = updateRoomDto.getStatus();
        if (updateRoomDto.getNroBeds() != 0)
            this.nroBeds = updateRoomDto.getNroBeds();
        if (updateRoomDto.getNroPersons() != 0)
            this.nroPersons = updateRoomDto.getNroPersons();
        if (updateRoomDto.getSize() != null)
            this.size = updateRoomDto.getSize();
        if (updateRoomDto.getPrice() != 0)
            this.price = updateRoomDto.getPrice();
        if (updateRoomDto.getDescription() != null)
            this.description = updateRoomDto.getDescription();
        if (updateRoomDto.getType() != null)
            this.type = updateRoomDto.getType();
        if (updateRoomDto.getView() != null)
            this.view = updateRoomDto.getView();
    }
}
