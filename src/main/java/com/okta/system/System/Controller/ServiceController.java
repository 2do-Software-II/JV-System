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

import com.okta.system.System.Dtos.CreateServiceDto;
import com.okta.system.System.Dtos.UpdateServiceDto;
import com.okta.system.System.Entities.Service;
import com.okta.system.System.Services.ServiceService;

@RestController
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/api/services")
    public List<Service> getAll() {
        return serviceService.getAll();
    }

    @PostMapping("/api/services")
    public Service create(@RequestBody CreateServiceDto createServiceDto) {
        return serviceService.create(createServiceDto);
    }

    @GetMapping("/api/services/{id}")
    public Service getOne(@PathVariable String id) {
        return serviceService.getOne(id);
    }

    @PutMapping("/api/services/{id}")
    public Service update(@PathVariable String id, @RequestBody UpdateServiceDto updateServiceDto) {
        return serviceService.update(id, updateServiceDto);
    }

    @DeleteMapping("/api/services/{id}")
    public void delete(@PathVariable String id) {
        serviceService.delete(id);
    }

}
