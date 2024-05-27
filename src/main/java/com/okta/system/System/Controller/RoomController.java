package com.okta.system.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.okta.system.System.Dtos.CreateRoomDto;
import com.okta.system.System.Dtos.UpdateRoomDto;
import com.okta.system.System.Entities.Room;
import com.okta.system.System.Services.RoomService;

@RestController
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/api/room")
    public List<Room> getAll() {
        return roomService.getAll();
    }

    @PostMapping("/api/room")
    public Room create(@RequestBody CreateRoomDto createRoomDto) {
        return roomService.create(createRoomDto);
    }

    @GetMapping("/api/room/by/{attr}/{value}")
    public List<Room> getOne(@PathVariable String attr, @PathVariable String value) {
        return roomService.getAllRoomsBy(attr, value);
    }

    @GetMapping("/api/room/{id}")
    public Room getOne(@PathVariable String id) {
        return roomService.getOne(id);
    }

    @PutMapping("/api/room/{id}")
    public Room update(@PathVariable String id, @RequestBody UpdateRoomDto updateRoomDto) {
        return roomService.update(id, updateRoomDto);
    }

    @DeleteMapping("/api/room/{id}")
    public void delete(@PathVariable String id) {
        roomService.delete(id);
    }

}
