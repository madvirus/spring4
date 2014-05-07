package net.madvirus.spring4.chap13.store.dao;

import net.madvirus.spring4.chap13.store.domain.Item;

public interface ItemDao {

	Item findById(Integer itemId);

}
