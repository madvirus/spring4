package net.madvirus.spring4.chap02.conf;

import java.util.Arrays;

import net.madvirus.spring4.chap02.User;
import net.madvirus.spring4.chap02.UserRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2 {

	@Bean
	public User user1() {
		return new User("bkchoi", "1234");
	}

	@Bean(name = "user2")
	public User user() {
		return new User("madvirus", "qwer");
	}

	@Bean
	public UserRepository userRepository() {
		UserRepository userRepo = new UserRepository();
		userRepo.setUsers(Arrays.asList(user1(), user()));
		return userRepo;
	}

}
