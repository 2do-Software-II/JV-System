package com.okta.system.System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.okta.system.System.Dtos.CreateResourceDto;
import com.okta.system.System.Entities.Resource;
import com.okta.system.System.Services.ResourceService;

@RestController
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @GetMapping("/api/resource/{id}")
    public List<Resource> getAll(@PathVariable String id) {
        return resourceService.getAll(id);
    }

    @PostMapping("/api/resource")
    public Resource create(@RequestBody CreateResourceDto createResourceDto) {
        return resourceService.create(createResourceDto);
    }

    @DeleteMapping("/api/resource/{id}")
    public void delete(@PathVariable String id) {
        resourceService.delete(id);
    }
}
