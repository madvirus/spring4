package net.madvirus.spring4.chap13.store.dao;

import org.springframework.stereotype.Repository;

import net.madvirus.spring4.chap13.store.model.Item;

@Repository
public interface ItemDao {

	Item findById(Integer itemId);

}
