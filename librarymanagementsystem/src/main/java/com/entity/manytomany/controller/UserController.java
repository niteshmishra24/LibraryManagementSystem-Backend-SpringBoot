package com.entity.manytomany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.manytomany.entity.User;
import com.entity.manytomany.service.UserService;

@RestController
@RequestMapping("/api/")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("users/add-user")
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @PutMapping("users/{id}/update-user")
    public void updateUser(@RequestBody User user,@PathVariable("id") long id){
        userService.updateUser(user, id);
    }

    @DeleteMapping("users/{id}/delete-user")
    public void deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
    }
}
