package net.madvirus.spring4.chap15.hr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import net.madvirus.spring4.chap15.common.AndCondition;
import net.madvirus.spring4.chap15.common.BooleanCondition;
import net.madvirus.spring4.chap15.common.JunctionCondition;
import net.madvirus.spring4.chap15.hr.model.Address;
import net.madvirus.spring4.chap15.hr.model.Employee;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class JdbcEmployeeDao implements EmployeeDao {

	private static final String SELECT_ALL_QUERY = "select * from EMPLOYEE";
	private JdbcTemplate jdbcTemplate;
	private EmployeeRowMapper rowMapper = new EmployeeRowMapper();

	public JdbcEmployeeDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Long insert(final Employee emp) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(
						"insert into EMPLOYEE " +
								"(EMPLOYEE_NUM, NAME, HOME_ADDR1, HOME_ADDR2, HOME_ZIPCODE, BIRTH_YEAR, TEAM_ID, JOINED_DATE) " +
								"values (?, ?, ?, ?, ?, ?, ?, ?)",
						new String[] { "EMPLOYEE_ID" });
				pstmt.setString(1, emp.getNumber());
				pstmt.setString(2, emp.getName());
				if (emp.getHomeAddress() != null) {
					pstmt.setString(3, emp.getHomeAddress().getAddr1());
					pstmt.setString(4, emp.getHomeAddress().getAddr2());
					pstmt.setString(5, emp.getHomeAddress().getZipCode());
				} else {
					pstmt.setNull(3, Types.VARCHAR);
					pstmt.setNull(4, Types.VARCHAR);
					pstmt.setNull(5, Types.VARCHAR);
				}
				if (emp.getTeamId() != null) {
					pstmt.setLong(6, emp.getTeamId());
				} else {
					pstmt.setNull(6, Types.INTEGER);
				}
				pstmt.setInt(7, emp.getBirtyYear());
				pstmt.setTimestamp(8, new Timestamp(emp.getJoinedDate().getTime()));
				return pstmt;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

	@Override
	public Employee selectOne(Long id) {
		List<Employee> emps = jdbcTemplate.query(
				"select * from EMPLOYEE where EMPLOYEE_ID = ?",
				new Object[] { id }, rowMapper);
		return emps.isEmpty() ? null : emps.get(0);
	}

	@Override
	public Employee selectByEmployeeNumber(String number) {
		List<Employee> emps = jdbcTemplate.query(
				"select * from EMPLOYEE where EMPLOYEE_NUM = ?",
				new Object[] { number }, rowMapper);
		return emps.isEmpty() ? null : emps.get(0);
	}

	@Override
	public List<Employee> selectList(SearchCondition cond) {
		if (cond.hasNoCond()) {
			return jdbcTemplate.query(SELECT_ALL_QUERY, rowMapper);
		} else {
			JunctionCondition andCondition = new AndCondition();
			if (cond.hasEmpNumber())
				andCondition.add(
						new BooleanCondition("EMPLOYEE_NUM = ?", cond.getEmpNumber()));
			if (cond.hasNameKeyword())
				andCondition.add(
						new BooleanCondition("NAME like ?", "%" + cond.getNameKeyword() + "%"));
			if (cond.hasFromJoinedDate())
				andCondition.add(
						new BooleanCondition("JOINED_DATE >= ?", cond.getFromJoinedDate()));
			if (cond.hasToJoinedDate())
				andCondition.add(
						new BooleanCondition("JOINED_DATE <= ?", cond.getToJoinedDate()));

			String query = "select * from EMPLOYEE";
			if (andCondition.hasConditions()) {
				query += " where " + andCondition.getQuery();
			}

			return jdbcTemplate.query(query,
					andCondition.getParams().toArray(),
					rowMapper);
		}
	}

	private final class EmployeeRowMapper implements RowMapper<Employee> {
		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee emp = new Employee();
			emp.setId(rs.getLong("EMPLOYEE_ID"));
			emp.setNumber(rs.getString("EMPLOYEE_NUM"));
			emp.setName(rs.getString("NAME"));
			Address addr = new Address();
			addr.setAddr1(rs.getString("HOME_ADDR1"));
			addr.setAddr1(rs.getString("HOME_ADDR2"));
			addr.setAddr1(rs.getString("HOME_ZIPCODE"));
			emp.setHomeAddress(addr);
			emp.setBirtyYear(rs.getInt("BIRTH_YEAR"));
			emp.setTeamId(rs.getLong("TEAM_ID"));
			emp.setJoinedDate(new Date(rs.getTimestamp("JOINED_DATE").getTime()));
			return emp;
		}
	}

}
