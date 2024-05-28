package com.okta.system.System.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okta.system.System.Dtos.CreateBookingDto;
import com.okta.system.System.Dtos.UpdateBookingDto;
import com.okta.system.System.Entities.Booking;
import com.okta.system.System.Entities.Customer;
import com.okta.system.System.Entities.Room;
import com.okta.system.System.Repositories.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository repository;
    @Autowired
    private RoomService roomService;
    @Autowired
    private CustomerService customerService;

    public List<Booking> getAll() {
        return repository.findAll();
    }

    public List<Booking> getAllBy(String attr, String value) {
        if (attr.equals("room")) {
            return repository.findByRoom(value);
        }
        if (attr.equals("status")) {
            return repository.findByStatus(value);
        }
        if (attr.equals("customer")) {
            return repository.findByCustomer(value);
        }
        return repository.findAll();
    }

    public Booking create(CreateBookingDto createBookingDto) {
        Room room = roomService.getOne(createBookingDto.getRoom());
        if (!room.getStatus().equals("Disponible")) {
            throw new RuntimeException("Room is not available");
        }
        Customer customer = customerService.getOne(createBookingDto.getCustomer());
        Booking booking = new Booking();
        booking.setDate(createBookingDto.getDate());
        booking.setTime(createBookingDto.getTime());
        booking.setStatus(createBookingDto.getStatus());
        booking.setPaymentMethod(createBookingDto.getPaymentMethod());
        booking.setStartDate(createBookingDto.getStartDate());
        booking.setEndDate(createBookingDto.getEndDate());
        booking.setRoom(room);
        booking.setCustomer(customer);
        if (createBookingDto.getPrePaid() != 0) {
            booking.setPrePaid(createBookingDto.getPrePaid());
        }
        if (createBookingDto.getFullPayment() != 0) {
            booking.setFullPayment(createBookingDto.getFullPayment());
        }
        if (createBookingDto.getCheckIn() != null) {
            booking.setCheckIn(createBookingDto.getCheckIn());
        }
        if (createBookingDto.getCheckOut() != null) {
            booking.setCheckOut(createBookingDto.getCheckOut());
        }
        Booking bookingSaved = repository.save(booking);
        roomService.updateStatus(room.getId(), "Reservado");
        return bookingSaved;
    }

    public Booking getOne(String id) {
        Optional<Booking> booking = repository.findById(id);
        if (booking.isEmpty()) {
            throw new RuntimeException("Booking not found");
        }
        return booking.get();
    }

    public Booking update(String id, UpdateBookingDto updateBookingDto) {
        Booking booking = getOne(id);
        booking.update(updateBookingDto);
        if (updateBookingDto.getCheckIn() != null) {
            Room room = booking.getRoom();
            roomService.updateStatus(room.getId(), "Ocupado");
        }
        if (updateBookingDto.getCheckOut() != null) {
            Room room = booking.getRoom();
            roomService.updateStatus(room.getId(), "Limpieza");
        }
        return repository.save(booking);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
