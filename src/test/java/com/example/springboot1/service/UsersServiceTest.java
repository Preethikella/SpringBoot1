package com.example.springboot1.service;
import static org.assertj.core.api.Assertions.assertThat;
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

	
	
}