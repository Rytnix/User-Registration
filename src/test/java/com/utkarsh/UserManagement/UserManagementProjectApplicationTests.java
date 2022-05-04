package com.utkarsh.UserManagement;

import com.utkarsh.UserManagement.model.User;
import com.utkarsh.UserManagement.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
class UserManagementProjectApplicationTests {


  @Autowired
	UserRepository repository;


         String adduser(){

			 User user = new User();
			 User user1 = new User();
			 user.setUsername("hello-utkarsh");
			 user.setFirstName("Utkarsh");
			 user.setLastName("yadav");
			 user.setEmail("contactutkars18@gmail.com");
			 user1.setUsername("hello-rishav");
			 user1.setFirstName("Rishav");
			 user1.setLastName("Raj");
			 user1.setEmail("riv@gmail.com");
			 repository.save(user);
			 repository.save(user1);

			 return ( repository.findAll().toString());


		 }

	@Test
	void RegisterUser() {
			 adduser();
		if(repository.findById(1).isPresent() ) {
			System.out.println("User Registered successfully");
		}
		else{
			System.out.println("Error");
		}
	}
	@Test
	void fetchUser(){
			 adduser();
		List<User> list;
	  	list = repository.findAll();
		System.out.println(list);

	}
	void showuser(){
		List<User> user = repository.findAll();
		System.out.println(user);
	}


	@Test
	void deleteAllUser(){
			 adduser();
		repository.deleteAll();
		if(repository.findAll().isEmpty()){
			System.out.println("All users Deleted");

		}
		else{
			System.out.println("Error");
		}
	}

}
