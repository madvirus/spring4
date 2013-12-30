package net.madvirus.spring4.chap02.search;

public class HttpSearchClient implements SearchClient {

	@Override
	public void addDocument(SearchDocument searchDocument) {
		System.out.println("문서 추가함");
	}

	@Override
	public void checkLive() {
		System.out.println("상태 확인");
	}

}
