package net.madvirus.spring4.chap06.board;

public class ReadArticleServiceImpl implements ReadArticleService {

	private ArticleDao articleDao;

	public void setArticleDao(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public Article read(Integer id) {
		System.out.printf("ReadArticleServiceImpl.read(%d) 호출됨\n", id);
		return articleDao.selectById(id);
	}
}
