package com.okta.system.System.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.okta.system.System.Dtos.UpdateBookingDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "booking")
public class Booking {

    @Id
    private String id;
    private String date;
    private String time;
    private String status;
    private String checkIn;
    private String checkOut;
    private float prePaid;
    private float fullPayment;
    private String paymentMethod;
    private String startDate;
    private String endDate;
    @DBRef
    private Room room;
    @DBRef
    private Customer customer;

    public void update(UpdateBookingDto updateBookingDto) {
        if (updateBookingDto.getDate() != null) {
            this.setDate(updateBookingDto.getDate());
        }
        if (updateBookingDto.getTime() != null) {
            this.setTime(updateBookingDto.getTime());
        }
        if (updateBookingDto.getStatus() != null) {
            this.setStatus(updateBookingDto.getStatus());
        }
        if (updateBookingDto.getCheckIn() != null) {
            this.setCheckIn(updateBookingDto.getCheckIn());
        }
        if (updateBookingDto.getCheckOut() != null) {
            this.setCheckOut(updateBookingDto.getCheckOut());
        }
        if (updateBookingDto.getPrePaid() != 0) {
            this.setPrePaid(updateBookingDto.getPrePaid());
        }
        if (updateBookingDto.getFullPayment() != 0) {
            this.setFullPayment(updateBookingDto.getFullPayment());
        }
        if (updateBookingDto.getPaymentMethod() != null) {
            this.setPaymentMethod(updateBookingDto.getPaymentMethod());
        }
        if (updateBookingDto.getStartDate() != null) {
            this.setStartDate(updateBookingDto.getStartDate());
        }
        if (updateBookingDto.getEndDate() != null) {
            this.setEndDate(updateBookingDto.getEndDate());
        }
    }

}
