package com.okta.system.System.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.okta.system.System.Entities.Room;

@Repository
public interface RoomRepository extends MongoRepository<Room, String> {

    List<Room> findBy(String attr, String value);

    List<Room> findByStatus(String value);

    List<Room> findByType(String value);

    List<Room> findByPrice(String value);

    List<Room> findByNroBeds(int value);

    List<Room> findByNroPersons(int value);

}
