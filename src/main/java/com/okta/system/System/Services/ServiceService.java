package com.okta.system.System.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.okta.system.System.Dtos.CreateServiceDto;
import com.okta.system.System.Dtos.UpdateServiceDto;
import com.okta.system.System.Entities.Service;
import com.okta.system.System.Repositories.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService {

    @Autowired
    private ServiceRepository repository;

    public List<Service> getAll() {
        return repository.findAll();
    }

    public Service create(CreateServiceDto createServiceDto) {
        Service service = new Service(
                createServiceDto.getName(),
                createServiceDto.getDescription());
        return repository.save(service);
    }

    public Service getOne(String id) {
        Optional<Service> service = repository.findById(id);
        if (service.isEmpty()) {
            throw new RuntimeException("Service not found");
        }
        return service.get();
    }

    public Service update(String id, UpdateServiceDto updateServiceDto) {
        Service service = getOne(id);
        if (updateServiceDto.getName() != null)
            service.setName(updateServiceDto.getName());
        if (updateServiceDto.getDescription() != null)
            service.setDescription(updateServiceDto.getDescription());
        return repository.save(service);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
