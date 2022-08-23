package com.example.springboot1.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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

@SpringBootTest
public class UsersServiceTest {
	
	@Autowired
	private UsersService usersService;
	
	@MockBean
	private UsersRepository usersRepository;
	
	@Test
	public void testsaveUsers() {
		Users user= new Users();
		user.setId(2);
		user.setUserId(1);
		user.setTitle("name");
		user.setBody("Preethi");
		
		Mockito.when(usersRepository.save(user)).thenReturn(user);
		
		assertThat(usersService.saveUsers(user)).isEqualTo(user);
	
		
		
	}
	@Test
	public void testfetchUserById() {
		Optional<Users> user= Optional.of(new Users(1,2, "name", "Preethi"));
		
		Mockito.when(usersRepository.findById(1)).thenReturn(user);
		assertThat(usersService.fetchUserById(1)).isEqualTo(user);
	
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
	
	Mockito.when(usersRepository.findAll()).thenReturn(usersList);
	assertThat(usersService.fetchAllUsers()).isEqualTo(usersList);
	
	}
	
	
	
	@Test
	public void testdeleteUserById() {
	Users user= new Users();
	user.setId(1);
	user.setUserId(2);
	user.setTitle("name");
	user.setBody("Preethi");
	
	usersService.deleteUserById(1);
	//assertEquals(usersService.deleteUserById(1), user);
	verify(usersRepository,times(1)).deleteById(1);
		
	}
	



	
}
