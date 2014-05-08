package net.madvirus.spring4.chap13.store.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.madvirus.spring4.chap13.store.domain.PaymentInfo;
import net.madvirus.spring4.chap13.store.domain.PaymentInfoRepository;

@Repository
public class HibernatePaymentInfoRepository implements PaymentInfoRepository {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(PaymentInfo paymentInfo) {
		sessionFactory.getCurrentSession().save(paymentInfo);
	}

}
