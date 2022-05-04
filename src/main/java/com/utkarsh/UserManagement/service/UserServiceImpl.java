package com.utkarsh.UserManagement.service;

import com.utkarsh.UserManagement.model.User;
import com.utkarsh.UserManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    public User addUser(User user) {

         return userRepository.save(user);
    }

    public User findUserbyId(int id) {

        return userRepository.findById(id).orElseThrow(()-> new IllegalStateException("User with id ->"+id+" not found"));
    }

    public User findUserByName(String username) {
        return userRepository.findByUsername(username);
    }

    public User updateExitingUser(User user) {
        Optional<User> userexits = userRepository.findById(user.getId());

        if(userexits.isEmpty()){
           return userRepository.save(user);
        }
        else{
            userRepository.deleteById(user.getId());
            userRepository.save(user);
        }
        return user;
    }

    public boolean deleteuser(int id) {
        Optional<User> exits = userRepository.findById(id);
        if(!exits.isEmpty()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public String showAllUser() {
        return userRepository.findAll().toString();
    }

    public String deleteAllUser() {

        List<User> userexits = userRepository.findAll();
        if(userexits.isEmpty()){

            HttpStatus status = HttpStatus.NOT_FOUND;
            System.out.println(status);
        }
        else {
            HttpStatus status = HttpStatus.FOUND;
            userRepository.deleteAll();
            System.out.println(status);
            return "All user got deleted";

        }
        return "No user to delete";
    }
}
