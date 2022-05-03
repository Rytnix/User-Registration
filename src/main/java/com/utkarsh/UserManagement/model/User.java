package com.utkarsh.UserManagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;
        private String firstName;
        private String lastName;
        @Column(unique = true)
        private String username;
        @Column(unique = true)
        private String email;

}
