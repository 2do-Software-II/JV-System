package com.okta.system.System.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Role")
public class Role {
    @Id
    private String id;
    private String name;
    private String description;

    public Role() {
    }

    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
