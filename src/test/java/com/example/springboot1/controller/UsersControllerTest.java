package com.example.springboot1.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboot1.model.Address;
import com.example.springboot1.model.Users;
import com.example.springboot1.service.UsersService;

@SpringBootTest
public class UsersControllerTest {
	
	@InjectMocks
	UsersController usersController;
	
	@Mock
	private UsersService usersService; 
	
	
	@Test
	public void testsaveUser() {
		
		Address address = new Address();
		address.setAddressId(1);
		address.setCity("vizag");
		address.setAddType("permanent");
		 List<Address> usersAddress = new ArrayList<>();
	      usersAddress.add(address);
		
		Users user = new Users();
		user.setId(1);
		user.setUserId(2);
		user.setTitle("name");
		user.setBody("Pavani");
		user.setAddress(usersAddress);
		
		
		Mockito.when(usersService.saveUsers(user)).thenReturn(user);
		assertThat(usersController.saveUser(user)).isEqualTo(user);
       assertEquals(2, user.getUserId());
			
	}
	@Test
	public void testfetchUser() { 
		
		Address address = new Address();
		address.setAddressId(1);
		address.setCity("vizag");
		address.setAddType("permanent");
		 List<Address> usersAddress = new ArrayList<>();
	      usersAddress.add(address);
	      
		Optional<Users> user= Optional.of(new Users(1,2, "name", "Preethi", usersAddress));
		
		Mockito.when(usersService.fetchUserById(1)).thenReturn(user);
		Optional<Users> user1= usersController.fetchUser(1);
		assertEquals(user.get().getBody(), user1.get().getBody());
	}
	
	@Test
	public void testfetchAllUsers() {
		
		Address address1 = new Address();
		address1.setAddressId(1);
		address1.setCity("vizag");
		address1.setAddType("permanent");
		 List<Address> usersAddress1 = new ArrayList<>();
	      usersAddress1.add(address1);
	      
	      Address address2 = new Address();
			address1.setAddressId(1);
			address1.setCity("Hyderabad");
			address1.setAddType("permanent");
			 List<Address> usersAddress2 = new ArrayList<>();
		      usersAddress2.add(address2);
			
		
	Users user1= new Users();
	user1.setId(2);
	user1.setUserId(1);
	user1.setTitle("name");
	user1.setBody("Preethi");
	user1.setAddress(usersAddress1);
	
	Users user2= new Users();
	user2.setId(2);
	user2.setUserId(3);
	user2.setTitle("name");
	user2.setBody("Pavani");
	user2.setAddress(usersAddress2);
	
	
	List<Users> usersList= new ArrayList<>();
	usersList.add(user1);
	usersList.add(user2);
	
	Mockito.when(usersService.fetchAllUsers()).thenReturn(usersList);
	assertThat(usersController.fetchAllUser()).isEqualTo(usersList);
	}

	
	
	@Test
	public void testdeleteUser() {
		
		Address address = new Address();
		address.setAddressId(1);
		address.setCity("vizag");
		address.setAddType("permanent");
		 List<Address> usersAddress = new ArrayList<>();
	      usersAddress.add(address);
		
	Users user= new Users();
	user.setId(1);
	user.setUserId(2);
	user.setTitle("name");
	user.setBody("Preethi");
	user.setAddress(usersAddress);
	
	  usersController.deleteUser(1);  
	   assertEquals(1, user.getId());
     
	}
	@Test
	public void testupdateUser() {
		
		Address address = new Address();
		address.setAddressId(1);
		address.setCity("vizag");
		address.setAddType("permanent");
		 List<Address> usersAddress = new ArrayList<>();
	      usersAddress.add(address);
		
		Users user= new Users(1,2,"name","Preethi", usersAddress);
	
		
		Mockito.when(usersService.updateUserById(1, user)).thenReturn(user);
		user.setUserId(3);;
		Mockito.when(usersService.updateUserById(1, user)).thenReturn(user);
		assertEquals(3, user.getUserId());	 
	    assertThat(usersController.updateUser(1, user)).isEqualTo(user);
		
		
	}
	


}
