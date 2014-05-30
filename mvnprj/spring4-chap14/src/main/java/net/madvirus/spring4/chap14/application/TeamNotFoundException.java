package net.madvirus.spring4.chap14.application;

public class TeamNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TeamNotFoundException(String msg) {
		super(msg);
	}

}
