package net.madvirus.spring4.chap12.store.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import net.madvirus.spring4.chap12.store.dao.ItemDao;
import net.madvirus.spring4.chap12.store.domain.Item;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class JdbcItemDao implements ItemDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcItemDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Item findById(Integer itemId) {
		return jdbcTemplate.queryForObject(
				"select * from ITEM where ITEM_ID = ?",
				new Object[] { itemId }, new RowMapper<Item>() {
					@Override
					public Item mapRow(ResultSet rs, int row)
							throws SQLException {
						Item item = new Item();
						item.setId(rs.getInt("ITEM_ID"));
						item.setPrice(rs.getInt("PRICE"));
						return item;
					}
				});
	}

}
