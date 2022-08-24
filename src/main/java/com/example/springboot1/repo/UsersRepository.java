package com.example.springboot1.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springboot1.model.Users;

public interface UsersRepository  extends JpaRepository<Users, Integer>{


}
