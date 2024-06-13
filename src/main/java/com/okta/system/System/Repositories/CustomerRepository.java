package com.okta.system.System.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.okta.system.System.Entities.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    List<Customer> findByUser(String id);
}
