package net.madvirus.spring4.chap16.security;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {

	private static final String PLAIN = "asdf";

	@Test
	public void bcrypt() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoded = encoder.encode(PLAIN);
		assertThat(encoder.matches(PLAIN, encoded), equalTo(true));

		String encoded2 = encoder.encode(PLAIN);
		assertThat(encoder.matches(PLAIN, encoded2), equalTo(true));

		assertThat(encoded, not(equalTo(encoded2)));
		
		System.out.println(encoded);
		System.out.println(encoded2);
	}

}
