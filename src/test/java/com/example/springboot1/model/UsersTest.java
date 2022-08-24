package com.example.springboot1.model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class UsersTest {
	
	
	public Users createTest(){
	      return new Users();
	     }
	
	 @Test
	 public void testGetId() {
		 Users users =null;
		 users = createTest();
	     users.getId();

	    } 
	 
	 @Test
	 public void setId() { 
		 int id=1;
		 Users users =null;
		 users = createTest();
		 users.setId(1);
	     assertEquals(users.getId(),id);

	    }      
	 
	 
	 @Test
	 public void testGetUserId() {
		 Users users =null;
		 users = createTest();
	     users.getUserId();

	    } 
	 
	 @Test
	 public void setUserId() {
		 long userId=2;
		 Users users =null;
		 users = createTest();
		 users.setUserId(2);
	     assertEquals(users.getUserId(),userId);

	    }    
	
	 @Test
	 public void testGetTitle() {
		 Users users =null;
		 users = createTest();
	     users.getTitle();

	    } 
	 
	 @Test
	 public void setTitle() {
		 String title="name";
		 Users users =null;
		 users = createTest();
		 users.setTitle(title);
	     assertEquals(users.getTitle(),title);

	    }    
	 
	 @Test
	 public void testGetBody() {
		 Users users =null;
		 users = createTest();
	     users.getBody();

	    } 
	 
	 @Test
	 public void setBody() {
		 String body= "Preethi";
		 Users users =null;
		 users = createTest();
		 users.setBody(body);;
	     assertEquals(users.getBody(),body);

	    }  
	 @Test
	 public void testGetAddress() {
	     List<Address> address= new ArrayList();
	     address=null;
	     Users users =null;
	     users = createTest();
	     address = users.getAddress();

	    } 
	 
	 @Test
	 public void setAddress() {
		 List<Address> address= new ArrayList();
	     address=null;
	     Users users =null;
	     users = createTest();
	     users.setAddress(address);
	    }
}
