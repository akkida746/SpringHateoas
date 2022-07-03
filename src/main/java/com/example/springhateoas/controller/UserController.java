package com.example.springhateoas.controller;

import com.example.springhateoas.UserService;
import com.example.springhateoas.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserController {

    //https://grapeup.com/blog/how-to-build-hypermedia-api-with-spring-hateoas/#

    private UserService userService = new UserService();

    @GetMapping("/users")
    public List<User> getAllUsers(){
        List<User> users = userService.getAllUsers();
        users.stream().forEach(user -> {
            user.add(linkTo(methodOn(UserController.class).getUserById(user.getId())).withSelfRel());
        });
        return users;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
}
