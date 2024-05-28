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

import com.okta.system.System.Dtos.CreateBookingDto;
import com.okta.system.System.Dtos.UpdateBookingDto;
import com.okta.system.System.Entities.Booking;
import com.okta.system.System.Services.BookingService;

@RestController
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/api/booking")
    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    @PostMapping("/api/booking")
    public Booking create(@RequestBody CreateBookingDto createBookingDto) {
        return bookingService.create(createBookingDto);
    }

    @GetMapping("/api/booking/by/{attr}/{value}")
    public List<Booking> getOne(@PathVariable String attr, @PathVariable String value) {
        return bookingService.getAllBy(attr, value);
    }

    @GetMapping("/api/booking/{id}")
    public Booking getOne(@PathVariable String id) {
        return bookingService.getOne(id);
    }

    @PutMapping("/api/booking/{id}")
    public Booking update(@PathVariable String id, @RequestBody UpdateBookingDto updateBookingDto) {
        return bookingService.update(id, updateBookingDto);
    }

    @DeleteMapping("/api/booking/{id}")
    public void delete(@PathVariable String id) {
        bookingService.delete(id);
    }
}
