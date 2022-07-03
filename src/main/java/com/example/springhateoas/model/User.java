package com.example.springhateoas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@AllArgsConstructor
public class User extends RepresentationModel<User> {
    private int id;
}
