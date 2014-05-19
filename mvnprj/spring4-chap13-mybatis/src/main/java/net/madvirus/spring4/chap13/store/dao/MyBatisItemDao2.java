package net.madvirus.spring4.chap13.store.dao;

import net.madvirus.spring4.chap13.store.model.Item;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class MyBatisItemDao2 extends SqlSessionDaoSupport implements ItemDao {

	@Override
	public Item findById(Integer itemId) {
		Item item = (Item) getSqlSession().selectOne(
				"net.madvirus.spring4.chap13.store.dao.ItemDao.findById",
				itemId);
		return item;
	}

}
