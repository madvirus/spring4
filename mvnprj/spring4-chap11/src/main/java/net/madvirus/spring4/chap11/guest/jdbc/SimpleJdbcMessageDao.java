package net.madvirus.spring4.chap11.guest.jdbc;

import javax.sql.DataSource;

import net.madvirus.spring4.chap11.guest.Message;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class SimpleJdbcMessageDao extends JdbcTemplateMessageDao {

	private SimpleJdbcInsert insertMessage;

	public SimpleJdbcMessageDao(DataSource dataSource) {
		super(dataSource);
		insertMessage = new SimpleJdbcInsert(dataSource);
	}

	@Override
	public int insert(Message message) {
		// TODO Auto-generated method stub
		return 0;
	}

}
