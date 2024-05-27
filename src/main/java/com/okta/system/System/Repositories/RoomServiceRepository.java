package com.okta.system.System.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.okta.system.System.Entities.RoomServiceEntity;

@Repository
public interface RoomServiceRepository extends MongoRepository<RoomServiceEntity, String> {

    List<RoomServiceEntity> findByRoom(String id);

}
