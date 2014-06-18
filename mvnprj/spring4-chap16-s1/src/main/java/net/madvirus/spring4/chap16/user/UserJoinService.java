package net.madvirus.spring4.chap16.user;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.transaction.annotation.Transactional;

public class UserJoinService {
	@Autowired
	private UserDetailsManager userDetailsManager;

	@Transactional
	public void join(NewUser newUser) {
		UserDetails user = new User(newUser.getName(), newUser.getPassword(),
				Collections.<GrantedAuthority> emptyList());
		try {
			userDetailsManager.createUser(user);
		} catch (DuplicateKeyException ex) {
			throw new DuplicateUsernameException(
					String.format("Username [%s] is aleady exists", newUser.getName()), ex);
		}
	}
}
