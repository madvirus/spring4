package net.madvirus.spring4.chap13.store.dao;

import net.madvirus.spring4.chap13.store.model.Item;

public interface ItemDao {

	Item findById(Integer itemId);

}
