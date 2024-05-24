package com.okta.system.System.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "service")
public class Service {

    @Id
    private String id;

    private String name;
    private String description;

    public Service() {
    }

    public Service(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
