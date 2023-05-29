package com.entity.manytomany.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.manytomany.entity.User;
import com.entity.manytomany.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void createUser(User user){
        userRepository.save(user);
    }

    public void updateUser(User user,long id){
        User existingUser = userRepository.findById(id).orElse(null);
        if(existingUser!=null){
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            userRepository.save(existingUser);
        }
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    }
}
