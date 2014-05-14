package net.madvirus.spring4.chap13.store.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import net.madvirus.spring4.chap13.store.domain.PaymentInfo;
import net.madvirus.spring4.chap13.store.domain.PaymentInfoRepository;

public class JpaPaymentInfoRepository implements PaymentInfoRepository {

	@PersistenceUnit(unitName = "shop")
	private EntityManagerFactory entityManagerFactory;

	@Override
	public void save(PaymentInfo paymentInfo) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.persist(paymentInfo);
	}

}
