package net.madvirus.spring4.chap13.store.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.madvirus.spring4.chap13.store.domain.PurchaseOrder;
import net.madvirus.spring4.chap13.store.domain.PurchaseOrderRepository;

public class JpaPurchaseOrderRepository implements PurchaseOrderRepository {

	@PersistenceContext(unitName = "shop")
	private EntityManager entityManager;

	@Override
	public void save(PurchaseOrder order) {
		entityManager.persist(order);
	}

}
