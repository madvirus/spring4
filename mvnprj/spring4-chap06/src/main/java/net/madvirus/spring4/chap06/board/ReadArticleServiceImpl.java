package net.madvirus.spring4.chap06.board;

public class ReadArticleServiceImpl implements ReadArticleService {

	private ArticleDao articleDao;

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public Article read(Integer id) {
		return articleDao.selectById(id);
	}
}
