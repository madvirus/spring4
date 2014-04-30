package net.madvirus.spring4.chap12.store.dao.jdbc;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import net.madvirus.spring4.chap12.store.dao.PurchaseOrderDao;
import net.madvirus.spring4.chap12.store.domain.PurchaseOrder;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class JdbcPurchaseOrderDao implements PurchaseOrderDao {

	private SimpleJdbcInsert insert;

	public JdbcPurchaseOrderDao(DataSource dataSource) {
		insert = new SimpleJdbcInsert(dataSource)
				.withTableName("PURCHASE_ORDER")
				.usingGeneratedKeyColumns("PURCHASE_ORDER_ID")
				.usingColumns("ITEM_ID", "PAYMENT_INFO_ID", "ADDRESS");
	}

	@Override
	public void insert(PurchaseOrder order) {
		Map<String, Object> args = new HashMap<String, Object>();
		args.put("ITEM_ID", order.getItemId());
		args.put("PAYMENT_INFO_ID", order.getPaymentInfoId());
		args.put("ADDRESS", order.getAddress());
		Number genId = insert.executeAndReturnKey(args);
		order.setId(genId.intValue());
	}

}
