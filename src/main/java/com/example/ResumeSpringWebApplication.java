package com.example;

import com.example.Entity.User;
import com.example.Service.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ResumeSpringWebApplication {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(ResumeSpringWebApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		CommandLineRunner clr = new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<User> users = userRepository.getAll();
				System.out.println(users);

			}
		};
		return clr;
	}
}
