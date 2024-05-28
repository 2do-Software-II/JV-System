package com.okta.system.System.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.okta.system.System.Entities.Booking;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {

    List<Booking> findByRoom(String value);

    List<Booking> findByStatus(String value);

    List<Booking> findByCustomer(String value);

}
