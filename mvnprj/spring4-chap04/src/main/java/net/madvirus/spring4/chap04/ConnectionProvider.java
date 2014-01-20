package net.madvirus.spring4.chap04;

import java.sql.Connection;

public interface ConnectionProvider {

	public Connection getConnection();
}
