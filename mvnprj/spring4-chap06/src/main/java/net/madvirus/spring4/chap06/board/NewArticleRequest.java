package net.madvirus.spring4.chap06.board;

public class NewArticleRequest {

	private String writerName;
	private String title;
	private String content;

	public NewArticleRequest(String writerName, String title, String content) {
		this.writerName = writerName;
		this.title = title;
		this.content = content;
	}

	public String getWriterName() {
		return writerName;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

}
