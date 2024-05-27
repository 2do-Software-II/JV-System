package com.okta.system.System.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.okta.system.System.Entities.Resource;

@Repository
public interface ResourceRepository extends MongoRepository<Resource, String> {

    List<Resource> findByRoom(String id);

}
