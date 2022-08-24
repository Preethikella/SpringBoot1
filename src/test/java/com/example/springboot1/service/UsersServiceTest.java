package com.example.springboot1.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboot1.model.Address;
import com.example.springboot1.model.Users;
import com.example.springboot1.repo.UsersRepository;
import com.example.springboot1.service.impl.UsersServiceImpl;

@SpringBootTest
public class UsersServiceTest {
	
	@Autowired
	private UsersService usersService;
	
	@Mock
	private UsersRepository usersRepository;
	

    @BeforeEach
    void initUseCase() {
        usersService = new UsersServiceImpl(usersRepository);
    } 
	@Test
	public void testsaveUsers() {
		
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
		
		Mockito.when(usersRepository.save(user)).thenReturn(user);
		 Users users = usersService.saveUsers(user);
		//assertThat(usersService.saveUsers(user)).isEqualTo(user);
		  assertEquals(users, user);
		  assertNotNull(users);
		
		
	}
	@Test
	public void testfetchUserById() {
		
		Address address = new Address();
		address.setAddressId(1);
		address.setCity("vizag");
		address.setAddType("permanent");
		 List<Address> usersAddress = new ArrayList<>();
	      usersAddress.add(address);
		 
		Optional<Users> user= Optional.of(new Users(1,2, "name", "Preethi", usersAddress));
		
		Mockito.when(usersRepository.findById(1)).thenReturn(user);
	        
	        Optional<Users> users=usersService.fetchUserById(1);
	        assertEquals(user.get().getUserId(), users.get().getUserId());
	        assertEquals(user.get().getTitle(), users.get().getTitle());
	        assertEquals(user.get().getBody(), users.get().getBody());
	
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
	
	Mockito.when(usersRepository.findAll()).thenReturn(usersList);
	assertThat(usersService.fetchAllUsers()).isEqualTo(usersList);
	
	}
	
	
	
	@Test
	public void testdeleteUserById() {
		
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
	
	usersService.deleteUserById(1);
	verify(usersRepository,times(1)).deleteById(1);
		
	}
	



	
}
