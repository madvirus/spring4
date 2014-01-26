package net.madvirus.spring4.chap06.board;

public class WriteArticleServiceImpl implements WriteArticleService {

	private ArticleDao articleDao;

	public WriteArticleServiceImpl(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public void write(NewArticleRequest newArticleReq) {
		Article article = toArticle(newArticleReq);
		articleDao.insert(article);
	}

	private Article toArticle(NewArticleRequest newArticleReq) {
		return new Article();
	}

}
