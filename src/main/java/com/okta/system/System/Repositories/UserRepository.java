package com.okta.system.System.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.okta.system.System.Entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
