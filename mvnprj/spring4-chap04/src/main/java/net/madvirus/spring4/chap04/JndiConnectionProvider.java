package net.madvirus.spring4.chap04;

import java.sql.Connection;

public class JndiConnectionProvider implements ConnectionProvider {

	private String jndiName;

	public void setJndiName(String jndiName) {
		this.jndiName = jndiName;
	}

	@Override
	public Connection getConnection() {
		System.out.println("JndiConnectionProvider: " + jndiName + " 연결 생성");
		return null;
	}

}
