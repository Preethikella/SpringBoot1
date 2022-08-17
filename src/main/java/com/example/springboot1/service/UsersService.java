package com.example.springboot1.service;

import java.util.List;

import com.example.springboot1.model.Users;

public interface UsersService {

	Users saveUsers(Users users);

	Users fetchUserById(int id);

	List<Users> fetchAllUsers();

	String deleteUserById(int id);

	//Users updateUserById(int id, Users users);

	Users updateUserById(Users users);
	


}
