package net.madvirus.spring4.chap12.store.dao.jdbc;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import net.madvirus.spring4.chap12.store.dao.PaymentInfoDao;
import net.madvirus.spring4.chap12.store.domain.PaymentInfo;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class JdbcPaymentInfoDao implements PaymentInfoDao {

	private SimpleJdbcInsert insert;

	public JdbcPaymentInfoDao(DataSource dataSource) {
		insert = new SimpleJdbcInsert(dataSource)
				.withTableName("PAYMENT_INFO")
				.usingGeneratedKeyColumns("PAYMENT_INFO_ID")
				.usingColumns("PRICE");
	}

	@Override
	public void insert(PaymentInfo paymentInfo) {
		Map<String, Object> paramValueMap = new HashMap<String, Object>();
		paramValueMap.put("PRICE", paymentInfo.getPrice());
		Number genId = insert.executeAndReturnKey(paramValueMap);
		paymentInfo.setId(genId.intValue());
	}

}
