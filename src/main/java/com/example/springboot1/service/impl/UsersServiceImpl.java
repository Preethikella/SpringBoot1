package com.example.springboot1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot1.model.Users;
import com.example.springboot1.repo.UsersRepository;
import com.example.springboot1.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService{
	
	@Autowired
	private UsersRepository usersRepository;
	
	

	public UsersServiceImpl(UsersRepository usersRepository) {
		super();
		this.usersRepository = usersRepository;
	}
 
	@Override
	public Users saveUsers(Users users) {
		Users usr=usersRepository.save(users);
		return usr;
	}

	@Override
	public Optional<Users> fetchUserById(int id) {
		return Optional.of(usersRepository.findById(id).get());
		
	}

	@Override
	public List<Users> fetchAllUsers() {
		return usersRepository.findAll();
	}

	@Override
	public String deleteUserById(int id) {
		usersRepository.deleteById(id);
		return "deleted";		
	}

	@Override
	public Users updateUserById(int id,Users users) {
		Users usr =	usersRepository.findById(id).orElse(null);
	//	usr.setId(users.getId());
	    usr.setUserId(users.getUserId());
		usr.setTitle(users.getTitle());
		usr.setBody(users.getBody());
		return  usersRepository.save(usr);
		
	//Optional<Users> usr= this.usersRepository.findById(users.getId());
	//if(usr.isPresent()) {
		//Users usrs= usr.get();
		//usrs.setUserId(users.getUserId());
		//usrs.setTitle(users.getTitle());
		//usrs.setBody(users.getBody());
		//usersRepository.save(usrs);
		//return usrs;
		//}else {
			//return new Users();
		//} 
			
	}

}
