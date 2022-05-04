package com.utkarsh.UserManagement.controller;

import com.utkarsh.UserManagement.model.User;
import com.utkarsh.UserManagement.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    //Rest Endpoints..


    //POST User


    //Register User
      @PostMapping("/registeruser")
       public User registerUser(@RequestBody User user){


          return userService.addUser(user);
      }



   // Fetch user
    @GetMapping("/showalluser")
   public String showalluser(){
          return userService.showAllUser();
    }



      @GetMapping("/showuser/{id}")
    public User showUserbyId(@PathVariable int id){

          return userService.findUserbyId(id);

      }

      @GetMapping("/showuserbyname/{username}")
    public User showUserByName(@PathVariable String username){

          return userService.findUserByName(username);
      }


      // Update user
      @PostMapping("/updateuser")
    public User updateUser(@RequestBody  User user){
          return userService.updateExitingUser(user);
      }


      //Delete user

    @PostMapping("/deletealluser")
    public String deleteAllUser(){
          return userService.deleteAllUser();
    }



    @PostMapping("/deleteUserbyid/{id}")
    public boolean deleteUser(@PathVariable int id){
          return userService.deleteuser(id);
    }
}



