package com.okta.system.System.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.okta.system.System.Dtos.CreateRoomDto;
import com.okta.system.System.Dtos.CreateRoomServiceDto;
import com.okta.system.System.Dtos.UpdateRoomDto;
import com.okta.system.System.Entities.Room;
import com.okta.system.System.Entities.RoomServiceEntity;
import com.okta.system.System.Entities.Service;
import com.okta.system.System.Repositories.RoomRepository;
import com.okta.system.System.Repositories.RoomServiceRepository;

@org.springframework.stereotype.Service
public class RoomService {

    @Autowired
    private RoomRepository repository;
    @Autowired
    private RoomServiceRepository roomServiceRepository;
    @Autowired
    private ServiceService serviceService;

    public List<Room> getAll() {
        return repository.findAll();
    }

    public List<Room> getAllRoomsBy(String attr, String value) {
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

    public Room updateStatus(String id, String status) {
        Room room = getOne(id);
        room.setStatus(status);
        return repository.save(room);
    }

    public RoomServiceEntity addServices(CreateRoomServiceDto createRoomServiceDto) {
        Room room = getOne(createRoomServiceDto.getRoom());
        Service service = serviceService.getOne(createRoomServiceDto.getService());
        RoomServiceEntity roomServiceEntity = new RoomServiceEntity(room, service);
        return roomServiceRepository.save(roomServiceEntity);
    }

    public List<RoomServiceEntity> getServicesByRoom(String id) {
        Room roomEntity = getOne(id);
        return roomServiceRepository.findByRoom(roomEntity.getId());

    }

}
