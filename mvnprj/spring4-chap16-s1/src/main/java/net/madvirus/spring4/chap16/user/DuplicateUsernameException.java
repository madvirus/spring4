package net.madvirus.spring4.chap16.user;

@SuppressWarnings("serial")
public class DuplicateUsernameException extends RuntimeException {

	public DuplicateUsernameException(String msg, Exception ex) {
		super(msg, ex);
	}

}
