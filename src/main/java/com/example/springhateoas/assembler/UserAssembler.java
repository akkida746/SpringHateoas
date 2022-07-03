package com.example.springhateoas.assembler;

import com.example.springhateoas.controller.UserController;
import com.example.springhateoas.model.User;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserAssembler implements SimpleRepresentationModelAssembler<User> {

    @Override
    public void addLinks(EntityModel<User> resource){
        int userId = resource.getContent().getId();
        resource.add(linkTo(methodOn(UserController.class).getUserById(userId)).withSelfRel());
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<User>> resources) {
        resources.add(linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel());
    }
}
