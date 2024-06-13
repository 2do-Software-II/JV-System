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

import com.okta.system.System.Dtos.CreateCustomerDto;
import com.okta.system.System.Dtos.UpdateCustomerDto;
import com.okta.system.System.Entities.Customer;
import com.okta.system.System.Services.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/api/customer")
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @PostMapping("/api/customer")
    public Customer create(@RequestBody CreateCustomerDto createCustomerDto) {
        return customerService.create(createCustomerDto);
    }

    @GetMapping("/api/customer/by/user/{id}")
    public Customer getCustomerByUser(@PathVariable String id) {
        return customerService.getCustomerByUser(id);
    }

    @GetMapping("/api/customer/{id}")
    public Customer getOne(@PathVariable String id) {
        return customerService.getOne(id);
    }

    @PutMapping("/api/customer/{id}")
    public Customer update(@PathVariable String id, @RequestBody UpdateCustomerDto updateCustomerDto) {
        return customerService.update(id, updateCustomerDto);
    }

    @DeleteMapping("/api/customer/{id}")
    public void delete(@PathVariable String id) {
        customerService.delete(id);
    }
}
