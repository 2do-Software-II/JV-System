package com.okta.system.System.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.okta.system.System.Dtos.UpdateCustomerDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "customer")
public class Customer {
    @Id
    private String id;
    private String name;
    private String lastName;
    private String phone;
    private String address;
    private String ci;
    private String expedition;
    private String birthDate;
    private String nationality;
    private String gender;
    private String preference;
    @DBRef
    private User user;

    public void update(UpdateCustomerDto updateCustomerDto) {
        if (updateCustomerDto.getName() != null) {
            this.name = updateCustomerDto.getName();
        }
        if (updateCustomerDto.getLastName() != null) {
            this.lastName = updateCustomerDto.getLastName();
        }
        if (updateCustomerDto.getPhone() != null) {
            this.phone = updateCustomerDto.getPhone();
        }
        if (updateCustomerDto.getAddress() != null) {
            this.address = updateCustomerDto.getAddress();
        }
        if (updateCustomerDto.getCi() != null) {
            this.ci = updateCustomerDto.getCi();
        }
        if (updateCustomerDto.getExpedition() != null) {
            this.expedition = updateCustomerDto.getExpedition();
        }
        if (updateCustomerDto.getBirthDate() != null) {
            this.birthDate = updateCustomerDto.getBirthDate();
        }
        if (updateCustomerDto.getNationality() != null) {
            this.nationality = updateCustomerDto.getNationality();
        }
        if (updateCustomerDto.getGender() != null) {
            this.gender = updateCustomerDto.getGender();
        }
        if (updateCustomerDto.getPreference() != null) {
            this.preference = updateCustomerDto.getPreference();
        }

    }

}
