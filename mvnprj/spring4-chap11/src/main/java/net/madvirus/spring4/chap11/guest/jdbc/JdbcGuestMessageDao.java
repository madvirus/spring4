package net.madvirus.spring4.chap11.guest.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import net.madvirus.spring4.chap11.guest.GuestMessage;
import net.madvirus.spring4.chap11.guest.GuestMessageDao;

public class JdbcGuestMessageDao implements GuestMessageDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcGuestMessageDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<GuestMessage> list(int start, int size) {
		List<GuestMessage> messages = jdbcTemplate.query("select * from guestmessage order by id desc limit ?, ?", 
				new Object[] {start, size},
				new RowMapper<GuestMessage>() {
					@Override
					public GuestMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
						GuestMessage m = new GuestMessage();
						
						return null;
					}});
		return messages;
	}

}
