package com.okta.system.System.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okta.system.System.Dtos.CreateResourceDto;
import com.okta.system.System.Entities.Resource;
import com.okta.system.System.Entities.Room;
import com.okta.system.System.Repositories.ResourceRepository;
import com.okta.system.System.Repositories.RoomRepository;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository repository;
    @Autowired
    private RoomRepository roomRepository;

    public List<Resource> getAll(String id) {
        Optional<Room> room = roomRepository.findById(id);
        if (room.isEmpty()) {
            throw new RuntimeException("Room not found");
        }
        return repository.findByRoom(room.get().getId());
    }

    public Resource create(CreateResourceDto createResourceDto) {
        Optional<Room> room = roomRepository.findById(createResourceDto.getRoom());
        if (room.isEmpty()) {
            throw new RuntimeException("Room not found");
        }
        Resource resource = new Resource();
        resource.setUrl(createResourceDto.getUrl());
        resource.setRoom(room.get());
        return repository.save(resource);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

}
