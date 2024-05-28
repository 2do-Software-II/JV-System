package com.okta.system.System.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "User")
public class User {

    @Id
    private String id;
    private String name;
    private String password;
    private String email;

    @DBRef
    private Role role;

    public User() {
    }

    public User(String name, String password, String email, Role role) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.email = email;
    }

}
