package com.example.springhateoas;

import com.example.springhateoas.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static List<User> users;
    static {
        users = new ArrayList<>();
        for(int i=0;i<5;i++){
            users.add(new User(i));
        }
    }
    public List<User> getAllUsers(){
        return users;
    }
    public User getUserById(int id){
        User user = null;
        for(User item: users){
            if(item.getId() == id){
                user = item;
                break;
            }
        }
        return user;
    }
}
