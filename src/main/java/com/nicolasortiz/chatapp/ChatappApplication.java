package com.nicolasortiz.chatapp;

import com.nicolasortiz.chatapp.model.entity.User;
import com.nicolasortiz.chatapp.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatappApplication implements CommandLineRunner {

	@Autowired
	private IUserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ChatappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setName("Juan Pérez");
		user1.setUsername("juanperez");
		user1.setEmail("juan@example.com");
		user1.setPassword("password1");

		User user2 = new User();
		user2.setName("María García");
		user2.setUsername("mariagarcia");
		user2.setEmail("maria@example.com");
		user2.setPassword("password2");

		User user3 = new User();
		user3.setName("Carlos López");
		user3.setUsername("carloslopez");
		user3.setEmail("carlos@example.com");
		user3.setPassword("password3");


		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
	}
}
