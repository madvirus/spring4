package net.madvirus.spring4.chap13.store.persistence;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import net.madvirus.spring4.chap13.store.domain.Item;
import net.madvirus.spring4.chap13.store.domain.ItemRepository;

public class JpaItemRepository implements ItemRepository {

	private EntityManagerFactory entityManagerFactory;

	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.entityManagerFactory = emf;
	}

	@Override
	public Item findById(Integer itemId) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Item item = entityManager.find(Item.class, itemId);
		item.setPrice(20000 + new Random().nextInt(1000));
		return item;
	}

}
