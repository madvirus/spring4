package net.madvirus.spring4.chap11.guest.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import net.madvirus.spring4.chap11.guest.Message;
import net.madvirus.spring4.chap11.guest.MessageDao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class JdbcTemplateMessageDao implements MessageDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplateMessageDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private RowMapper<Message> messageRowMapper = new MessageRowMapper();

	@Override
	public List<Message> select(int start, int size) {
		List<Message> messages = jdbcTemplate.query(
				"select * from guestmessage order by id desc limit ?, ?",
				new Object[] { start, size },
				messageRowMapper
				);
		return messages;
	}

	@Override
	public int counts() {
		return jdbcTemplate.queryForObject(
				"select count(*) from guestmessage",
				Integer.class);
	}

	@Override
	public int insert(final Message message) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				PreparedStatement pstmt = conn
						.prepareStatement(
								"insert into guestmessage (name, message, creationTime) values (?,?,?)",
								new String[] { "id" });
				pstmt.setString(1, message.getName());
				pstmt.setString(2, message.getMessage());
				pstmt.setTimestamp(3, new Timestamp(message.getCreationTime()
						.getTime()));
				return pstmt;
			}
		}, keyHolder);
		Number idNum = keyHolder.getKey();
		return idNum.intValue();
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("delete from guestmessage where id = ?", id);
	}

}
