package com.utkarsh.UserManagement.service;

import com.utkarsh.UserManagement.model.User;
import com.utkarsh.UserManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<User> showAllUser() {
        return userRepository.findAll();
    }
}
