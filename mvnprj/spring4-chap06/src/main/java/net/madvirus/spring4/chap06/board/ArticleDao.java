package net.madvirus.spring4.chap06.board;

public interface ArticleDao {

	void insert(Article article);

	Article selectById(Integer id);

}
