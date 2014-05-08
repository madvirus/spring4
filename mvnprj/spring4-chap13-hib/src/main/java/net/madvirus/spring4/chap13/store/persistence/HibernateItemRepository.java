package net.madvirus.spring4.chap13.store.persistence;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import net.madvirus.spring4.chap13.store.domain.Item;
import net.madvirus.spring4.chap13.store.domain.ItemRepository;

@Repository
public class HibernateItemRepository implements ItemRepository {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Item findById(Integer itemId) {
		Item item = (Item) sessionFactory.getCurrentSession().get(Item.class, itemId);
		return item;
	}

}
