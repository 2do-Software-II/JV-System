package com.okta.system.System.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "roomService")
public class RoomService {

    @Id
    private String id;
    @DBRef
    private Room room;
    @DBRef
    private Service service;

    public RoomService() {
    }

    public RoomService(Room room, Service service) {
        this.room = room;
        this.service = service;
    }

}
