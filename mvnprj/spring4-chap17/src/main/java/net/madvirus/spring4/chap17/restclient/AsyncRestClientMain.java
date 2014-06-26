package net.madvirus.spring4.chap17.restclient;

import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.client.AsyncRestTemplate;

public class AsyncRestClientMain {

	public static void main(String[] args) {
		AsyncRestTemplate asyncTemplate = new AsyncRestTemplate();
		ListenableFuture<ResponseEntity<String>> future = asyncTemplate.getForEntity("http://www.daum.net", String.class);
		future.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {
			@Override
			public void onSuccess(ResponseEntity<String> s) {
				String content = s.getBody();
				System.out.println(content.substring(0, 100));
			}
			@Override
			public void onFailure(Throwable t) {
				// 익셉션 처리
			}
		});
	}
}
