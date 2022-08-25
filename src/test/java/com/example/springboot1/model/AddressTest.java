package com.example.springboot1.model;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class AddressTest {
	
	public Address createTest(){
	      return new Address();
	     }
	
	
	 @Test
	 public void testGetAdressId() {
		 Address address =null;
		 address = createTest();
		 address.getAddressId();

	    } 
	 
	 @Test
	 public void setAdressId() { 
		 int addressId=1;
		 Address address =null;
		 address = createTest();
		 address.setAddressId(1);
	     assertEquals(address.getAddressId(),addressId);

	    }    
	 
	 @Test
	 public void testGetCity() {
		 Address address=null;
		 address = createTest();
		 address.getCity();
	 }
	     @Test
		 public void setCity() { 
			 String city="vizag";
			 Address address =null;
			 address = createTest();
			 address.setCity(city);
		     assertEquals(address.getCity(),city);

		    }    
		 
		 @Test
		 public void testGetAddType() {
			 Address address=null;
			 address = createTest();
			 address.getAddType();
		 }
		 @Test
			 public void setAddType() { 
				 String addType="vizag";
				 Address address =null;
				 address = createTest();
				 address.setAddType(addType);
			     assertEquals(address.getAddType(),addType);

			    } 
		
	}

