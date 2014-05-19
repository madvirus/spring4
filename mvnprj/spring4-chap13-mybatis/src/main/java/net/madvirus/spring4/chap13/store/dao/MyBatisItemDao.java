package net.madvirus.spring4.chap13.store.dao;

import net.madvirus.spring4.chap13.store.model.Item;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisItemDao implements ItemDao {

	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Item findById(Integer itemId) {
		Item item = (Item) sqlSession.selectOne(
				"net.madvirus.spring4.chap13.store.dao.ItemDao.findById",
				itemId);
		return item;
	}

}
