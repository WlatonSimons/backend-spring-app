package com.team5.mortgage;

import com.team5.mortgage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MorgageApplicationTests {

	@Autowired
	private UserService userService;

	/*@Test
	void createUser() {
		User createUser = new User();
		createUser.setUsername("Labas");
		createUser.setPassword("1111");
		createUser.setEmail("labas@gmail.com");

		System.out.println(userService.createUser(createUser).toString());
	}

	@Test
	void deleteUser() {
		userService.delete(1);
	}*/
}
