package net.madvirus.spring4.chap13.store.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.madvirus.spring4.chap13.store.domain.PurchaseOrder;
import net.madvirus.spring4.chap13.store.domain.PurchaseOrderRepository;

@Repository
public class HibernatePurchaseOrderRepository implements PurchaseOrderRepository {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(PurchaseOrder order) {
		sessionFactory.getCurrentSession().save(order);
	}

}
