package com.example.springboot1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address_table")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "address_id")
	private int addressId;
	private String city;
	private String addType;
	
		
	public Address() {
		
	}


	public Address(String city, String addType) {
		super();
		this.city = city;
		this.addType = addType;
	}


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getAddType() {
		return addType;
	}


	public void setAddType(String addType) {
		this.addType = addType;
	}



}
