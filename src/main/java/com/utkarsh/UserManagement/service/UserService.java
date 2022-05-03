package com.utkarsh.UserManagement.service;

import com.utkarsh.UserManagement.model.User;
import com.utkarsh.UserManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User addUser(User user) {

         return userRepository.save(user);
    }

    public List<User> addMultipleUser(List<User> user) {

        return userRepository.saveAll(user);

    }


    public User findUserbyId(int id) {

        return userRepository.findById(id).orElseThrow(()-> new IllegalStateException("User with id ->"+id+" not found"));
    }

    public User findUserByName(String username) {
        return userRepository.findByUsername(username);
    }

    public User updateExitingUser(User user) {
        User userexits = userRepository.findById(user.getId()).orElseThrow(()->new IllegalStateException("User already exists"));

        if(userexits==null){
           return userRepository.save(user);
        }
        else{
            userRepository.deleteById(user.getId());
            userRepository.save(user);
        }
        return user;
    }

    public boolean deleteuser(User user) {
        User exits = userRepository.findById(user.getId()).orElseThrow(()->new IllegalStateException("User not found"));
        if(exits!=null){
            userRepository.delete(user);
            return true;
        }
        return false;
    }
}
