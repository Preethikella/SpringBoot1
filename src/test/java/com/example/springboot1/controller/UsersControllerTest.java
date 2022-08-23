package com.example.springboot1.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.example.springboot1.model.Users;
import com.example.springboot1.repo.UsersRepository;
import com.example.springboot1.service.UsersService;
@SpringBootTest
public class UsersControllerTest {
	
	@Autowired
	private UsersController usersController;
	
	@MockBean
	private UsersService usersService; 
	
	@MockBean
	private UsersRepository usersRepository;
	
	@Test
	public void testsaveUser() {
		
		Users user = new Users();
		user.setId(1);
		user.setUserId(2);
		user.setTitle("name");
		user.setBody("Pavani");
		
		
		Mockito.when(usersService.saveUsers(user)).thenReturn(user);
        assertThat(usersController.saveUser(user)).isEqualTo(user);
			
	}
	@Test
	public void testfetchUser() {
		Optional<Users> user= Optional.of(new Users(1,2, "name", "Preethi"));
		
		Mockito.when(usersService.fetchUserById(1)).thenReturn(user);
		assertThat(usersController.fetchUser(1)).isEqualTo(user);
	}
	
	@Test
	public void testfetchAllUsers() {
	Users user1= new Users();
	user1.setId(2);
	user1.setUserId(1);
	user1.setTitle("name");
	user1.setBody("Preethi");
	
	Users user2= new Users();
	user2.setId(2);
	user2.setUserId(3);
	user2.setTitle("name");
	user2.setBody("Pavani");
	
	
	List<Users> usersList= new ArrayList<>();
	usersList.add(user1);
	usersList.add(user2);
	
	Mockito.when(usersService.fetchAllUsers()).thenReturn(usersList);
	assertThat(usersController.fetchAllUser()).isEqualTo(usersList);
	}

	
	
	@Test
	public void testdeleteUser() {
	Users user= new Users();
	user.setId(1);
	user.setUserId(2);
	user.setTitle("name");
	user.setBody("Preethi");
	
	  usersController.deleteUser(1); 
	   assertEquals(1, user.getId());
     
	}
	
	public void updateUser() {
		Users user= new Users();
		user.setId(1);
		user.setUserId(2);
		user.setTitle("name");
		user.setBody("Preethi");
		
		Mockito.when(usersService.updateUserById(user)).thenReturn(user);
		assertThat(usersController.updateUser(user)).isEqualTo(user);
	}
	


}
