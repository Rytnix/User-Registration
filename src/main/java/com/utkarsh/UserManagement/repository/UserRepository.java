package com.utkarsh.UserManagement.repository;

import com.utkarsh.UserManagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {


    User findByUsername(String username);


}
