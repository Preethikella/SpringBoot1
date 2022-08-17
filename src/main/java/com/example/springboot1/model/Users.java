package com.example.springboot1.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name= "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private long userId; 
	private String title;
	private String body;
	
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name = "fk_adds_id")
	
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "fk_adds_id", referencedColumnName = "id")
	//private List<Address> address;
	
	public Users(){
		
	}

	public Users(long userId, String title, String body, List<Address> address) {
		super();
		this.userId = userId;
		this.title = title;
		this.body = body;
		//this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	//public List<Address> getAddress() {
		//return address;
	//}

	//public void setAddress(List<Address> address) {
		//this.address = address;
	//}
		
}
