package net.madvirus.spring4.chap16.user;

import java.util.Arrays;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.transaction.annotation.Transactional;

public class UserJoinService {
	private UserDetailsManager userDetailsManager;
	private PasswordEncoder passwordEncoder;

	public UserJoinService() {
		passwordEncoder = NoOpPasswordEncoder.getInstance();
	}

	@Transactional
	public void join(NewUser newUser) {
		String password = passwordEncoder.encode(newUser.getPassword());
		UserDetails user = new User(newUser.getName(), password,
				Arrays.asList(new SimpleGrantedAuthority("USER")));
		try {
			userDetailsManager.createUser(user);
		} catch (DuplicateKeyException ex) {
			throw new DuplicateUsernameException(
					String.format("Username [%s] is aleady exists", newUser.getName()), ex);
		}
	}

	public void setUserDetailsManager(UserDetailsManager userDetailsManager) {
		this.userDetailsManager = userDetailsManager;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}
}
