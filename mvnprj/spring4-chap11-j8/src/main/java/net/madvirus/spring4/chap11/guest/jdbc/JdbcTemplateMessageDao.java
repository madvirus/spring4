package net.madvirus.spring4.chap11.guest.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import net.madvirus.spring4.chap11.guest.Message;
import net.madvirus.spring4.chap11.guest.MessageDao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class JdbcTemplateMessageDao implements MessageDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateMessageDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Message> select(int start, int size) {
        List<Message> messages = jdbcTemplate.query(
                "select * from guestmessage order by id desc limit ?, ?",
                new Object[]{start, size},
                (rs, rowNum) -> {
                    Message m = new Message();
                    m.setId(rs.getInt("id"));
                    m.setName(rs.getString("name"));
                    m.setMessage(rs.getString("message"));
                    m.setCreationTime(rs.getTimestamp("creationTime"));
                    return m;
                }
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
    public int insert(Message message) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((Connection conn) -> {
                PreparedStatement pstmt = conn
                        .prepareStatement(
                                "insert into guestmessage (name, message, creationTime) values (?,?,?)",
                                new String[]{"id"});
                pstmt.setString(1, message.getName());
                pstmt.setString(2, message.getMessage());
                pstmt.setTimestamp(3, new Timestamp(message.getCreationTime()
                        .getTime()));
                return pstmt;
            }
        , keyHolder);
        Number idNum = keyHolder.getKey();
        return idNum.intValue();
    }

}
