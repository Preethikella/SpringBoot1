package com.example.springboot1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot1.model.Users;
import com.example.springboot1.service.UsersService;

@RestController
public class UsersController {
	
	@Autowired
	private UsersService usersService;

	
	@PostMapping("/saveUsers")
	public Users saveUser(@RequestBody Users users) {
		return usersService.saveUsers(users);
	}
	
	@GetMapping("/getUsers/{id}")
	public Users fetchUser(@PathVariable int id) {
		return usersService.fetchUserById(id);
	}
	
	@GetMapping("/getUsers")
	public List<Users> fetchAllUser(){
		return usersService.fetchAllUsers();

	}
	
	@DeleteMapping("/deleteUsers/{id}")
	public String deleteUser(@PathVariable int id) {
		return usersService.deleteUserById(id);
	}
	@PutMapping("/updateUsers")
	public Users updateUser(@RequestBody Users users) {
	  return usersService.updateUserById(users);
		
		
	}

}
