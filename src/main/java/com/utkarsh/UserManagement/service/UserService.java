package com.utkarsh.UserManagement.service;

import com.utkarsh.UserManagement.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User addUser(User user);
    User findUserbyId(int id);
    User findUserByName(String username)   ;
    User updateExitingUser(User user);
    boolean deleteuser(int id);
    String showAllUser();
    String deleteAllUser();

}
