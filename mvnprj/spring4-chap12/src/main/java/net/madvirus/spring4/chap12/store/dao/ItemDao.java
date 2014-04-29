package net.madvirus.spring4.chap12.store.dao;

import net.madvirus.spring4.chap12.store.domain.Item;

public interface ItemDao {

	Item findById(Integer itemId);

}
