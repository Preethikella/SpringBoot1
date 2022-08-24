package com.example.springboot1.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import com.example.springboot1.model.Address;
import com.example.springboot1.model.Users;
import com.example.springboot1.repo.UsersRepositoryH2;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsersControllerIntegrationTest {
	
	@LocalServerPort
	private int port;
	
	private String baseUrl="http://localhost";
	
	private static RestTemplate restTemplate;
	
	@Autowired	
	private UsersRepositoryH2 usersRepositoryH2;
	
	@BeforeAll 
	public static void init() {
		restTemplate = new RestTemplate();
		
	}
	
	@BeforeEach
	public void setUp() {
		baseUrl=baseUrl.concat(":").concat(port+"");
	}
	 
	
	@Test
	//@Sql(statements = "DELETE FROM users WHERE title=name", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testsaveUser() {
		
		Address address = new Address();
		address.setAddressId(1);
		address.setCity("vizag");
		address.setAddType("permanent");
		 List<Address> usersAddress = new ArrayList<>();
	      usersAddress.add(address);
		
		Users user = new Users(1,2,"name","Pavani", usersAddress);
		Users user1 =restTemplate.postForObject(baseUrl.concat("/saveUsers"), user, Users.class);
		assertEquals(1, user1.getId());
		assertEquals(2, user1.getUserId());
		assertEquals("name", user1.getTitle());
		assertEquals("Pavani", user1.getBody());
		assertEquals(1, usersRepositoryH2.findAll().size());
	
	}
	
	@Test
	@Sql(statements = "INSERT INTO users(id,user_id,title,body) VALUES(2,2,'name','Preethi')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE FROM users WHERE id=2", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testfetchAllUsers() {
		
		List<Users> users=restTemplate.getForObject(baseUrl.concat("/getUsers"),List.class);
		assertEquals(2, users.size());
		assertEquals(2, usersRepositoryH2.findAll().size());	
		
	}

	@Test
	@Sql(statements = "INSERT INTO users(id,user_id,title,body) VALUES(2,2,'name','Pavani')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE FROM users WHERE id=2", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void testfetchUser() {
    	
	    Users user=restTemplate.getForObject(baseUrl+"/getUsers/{id}",Users.class,2);
	    assertNotNull(user);
	    assertEquals(2, user.getId());
	    assertEquals(2,usersRepositoryH2.findAll().size());	    
	
} 
	@Test
	@Sql(statements = "INSERT INTO users(id,user_id,title,body) VALUES(2,2,'name','Preethi')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	@Sql(statements = "DELETE FROM users WHERE id=2", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
	public void testupdateUser() {
		
		Address address = new Address();
		address.setAddressId(1);
		address.setCity("vizag");
		address.setAddType("permanent");
		 List<Address> usersAddress = new ArrayList<>();
	      usersAddress.add(address);
		
		Users user = new Users(2,2,"surName","Pavani", usersAddress);
		  restTemplate.put(baseUrl+"/updateUsers/{id}", user,1);
		Users userFromDB = usersRepositoryH2.findById(1).get(); 
		assertNotNull(userFromDB);
		assertEquals("Pavani", user.getBody());
		
		
	}
	
	@Test
	@Sql(statements = "INSERT INTO users(id,user_id,title,body) VALUES(2,2,'name','Preethi')", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
	public void testdeleteUser() {
		int userCount= usersRepositoryH2.findAll().size();
		assertEquals(2, userCount);
		 restTemplate.delete(baseUrl+"/deleteUsers/{id}",2);
		int userCount1= usersRepositoryH2.findAll().size();
		assertEquals(1, userCount1);
		
	} 
	
	
	
}
