package net.madvirus.spring4.chap02.search;

public class SearchClientFactoryBuilder {

	private String host;
	private int port;
	private String contentType;
	private String encoding;
	
	public SearchClientFactoryBuilder server(String host) {
		this.host = host;
		return this;
	}
	
	public SearchClientFactoryBuilder port(int port) {
		this.port = port;
		return this;
	}
	
	public SearchClientFactoryBuilder contentType(String contentType) {
		this.contentType = contentType;
		return this;
	}
	
	public SearchClientFactoryBuilder encoding(String encoding) {
		this.encoding = encoding;
		return this;
	}
	
	public SearchClientFactory build() {
		return new HttpSearchClientFactory(host+":"+port, contentType, encoding);
	}
}
