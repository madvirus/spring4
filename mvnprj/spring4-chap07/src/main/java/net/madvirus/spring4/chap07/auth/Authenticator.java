package net.madvirus.spring4.chap07.auth;

public class Authenticator {

	public void authenticate(String email, String password) {
		if (!password.equals("1234"))
			throw new AuthenticationException();
	}

}
