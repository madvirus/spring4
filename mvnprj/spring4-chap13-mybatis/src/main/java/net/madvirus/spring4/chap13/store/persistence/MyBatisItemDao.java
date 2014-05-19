package net.madvirus.spring4.chap13.store.persistence;

import org.mybatis.spring.SqlSessionTemplate;

import net.madvirus.spring4.chap13.store.domain.Item;
import net.madvirus.spring4.chap13.store.domain.ItemRepository;

public class MyBatisItemDao implements ItemRepository {

	private SqlSessionTemplate sqlSessionTemplate;

	public void setSqlSessionTemplate(SqlSessionTemplate sqlSession) {
		this.sqlSessionTemplate = sqlSession;
	}

	@Override
	public Item findById(Integer itemId) {
		Item item = (Item) sqlSessionTemplate.selectOne(
				"net.madvirus.spring4.chap13.store.persistence.MyBatisItemDao.findById", 
				itemId);
		return item;
	}

}
