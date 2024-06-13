package com.okta.system.System.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.okta.system.System.Dtos.CreateCustomerDto;
import com.okta.system.System.Dtos.UpdateCustomerDto;
import com.okta.system.System.Entities.Customer;
import com.okta.system.System.Entities.User;
import com.okta.system.System.Repositories.CustomerRepository;
import com.okta.system.System.Repositories.UserRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private UserRepository userRepository;

    public List<Customer> getAll() {
        return repository.findAll();
    }

    public Customer create(CreateCustomerDto createCustomerDto) {
        Optional<User> user = userRepository.findById(createCustomerDto.getUser());
        if (user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        System.out.println(user.get());
        Customer customer = new Customer();
        customer.setName(createCustomerDto.getName());
        customer.setLastName(createCustomerDto.getLastName());
        customer.setAddress(createCustomerDto.getAddress());
        customer.setPhone(createCustomerDto.getPhone());
        customer.setCi(createCustomerDto.getCi());
        customer.setExpedition(createCustomerDto.getExpedition());
        customer.setBirthDate(createCustomerDto.getBirthDate());
        customer.setNationality(createCustomerDto.getNationality());
        customer.setGender(createCustomerDto.getGender());
        customer.setPreference(createCustomerDto.getPreference());
        customer.setUser(user.get());
        return repository.save(customer);
    }

    public Customer getOne(String id) {
        Optional<Customer> customer = repository.findById(id);
        if (customer.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }
        return customer.get();
    }

    public Customer update(String id, UpdateCustomerDto updateCustomerDto) {
        Customer customer = getOne(id);
        customer.update(updateCustomerDto);
        return repository.save(customer);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public Customer getCustomerByUser(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("user not found");
        }
        List<Customer> customers = repository.findAll();
        for (Customer customer : customers) {
            if (customer.getUser().getId().equals(id)) {
                return customer;
            }
        }
        throw new RuntimeException("Customer not found");
    }
}
