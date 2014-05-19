package net.madvirus.spring4.chap13.store.dao;

import org.springframework.stereotype.Repository;

import net.madvirus.spring4.chap13.store.model.PurchaseOrder;

@Repository
public interface PurchaseOrderDao {

	void save(PurchaseOrder order);

}
