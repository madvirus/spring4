package net.madvirus.spring4.chap17.restclient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClientMain {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = 
				restTemplate.getForEntity("http://www.daum.net", String.class);
		String body = responseEntity.getBody();
		System.out.println(body);
	}
}
