package net.madvirus.spring4.chap11.guest.jdbc;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import net.madvirus.spring4.chap11.guest.Message;
import net.madvirus.spring4.chap11.guest.MessageDao;

public class NamedJdbcTemplateMessageDao implements MessageDao {

	private NamedParameterJdbcTemplate template;

	public NamedJdbcTemplateMessageDao(DataSource dataSource) {
		this.template = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public List<Message> select(int start, int size) {
		Map<String, Object> params = new HashMap<>();
		params.put("start", start);
		params.put("size", size);
		List<Message> messages = template.query(
				"select * from guestmessage order by id desc limit :start, :size",
				params,
				new MessageRowMapper()
				);
		return messages;
	}

	@Override
	public int counts() {
		return template.queryForObject(
				"select count(*)from guestmessage", 
				Collections.<String, Object>emptyMap(), 
				Integer.class);
		//return template.getJdbcOperations().queryForObject("select count(*) from guestmessage", Integer.class);
	}

	@Override
	public int insert(Message message) {
		SqlParameterSource paramSource = new BeanPropertySqlParameterSource(message);
		KeyHolder keyHolder = new GeneratedKeyHolder();
		template.update("insert into guestmessage (name, message, creationTime) values (:name, :message,:creationTime)", paramSource, keyHolder);
		Number idNum = keyHolder.getKey();
		return idNum.intValue();
	}

	@Override
	public int delete(int id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("id", id);
		return template.update("delete from guestmessage where id = :id", paramSource);
	}

}
