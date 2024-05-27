package com.okta.system.System.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okta.system.System.Dtos.CreateRoomDto;
import com.okta.system.System.Dtos.UpdateRoomDto;
import com.okta.system.System.Entities.Room;
import com.okta.system.System.Repositories.RoomRepository;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repository;

    public List<Room> getAll() {
        return repository.findAll();
    }

    public List<Room> getAllRoomsBy(String attr, String value) {
        System.out.println("attr: " + attr + " value: " + value);
        if (attr.equals("status")) {
            return repository.findByStatus(value);
        }
        if (attr.equals("type")) {
            return repository.findByType(value);
        }
        if (attr.equals("price")) {
            return repository.findByPrice(value);
        }
        if (attr.equals("nroBeds")) {
            System.out.println("nroBeds:" + value);
            return repository.findByNroBeds(Integer.parseInt(value));
        }
        if (attr.equals("nroPersons")) {
            return repository.findByNroPersons(Integer.parseInt(value));
        }
        return repository.findBy(attr, value);
    }

    public Room create(CreateRoomDto createRoomDto) {
        Room room = new Room(createRoomDto);
        return repository.save(room);
    }

    public Room getOne(String id) {
        Optional<Room> room = repository.findById(id);
        if (room.isEmpty()) {
            throw new RuntimeException("Room not found");
        }
        return room.get();
    }

    public Room update(String id, UpdateRoomDto updateRoomDto) {
        Room service = getOne(id);
        service.update(updateRoomDto);
        return repository.save(service);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
