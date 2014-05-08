package net.madvirus.spring4.chap13.store.domain;


public interface ItemRepository {

	Item findById(Integer itemId);

}
