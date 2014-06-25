package net.madvirus.spring4.chap17.restclient;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class RestClientMain {

	private static RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		simpleGet();

		getForObjectByVariableArg();
		getForObjectByVariableMap();

		postForLocation();

		exchange();

		catchException();
	}

	private static void simpleGet() {
		printTitle("simpleGet");
		String body = restTemplate.getForObject("http://www.daum.net", String.class);
		System.out.println(body.substring(0, 100));
	}

	private static void getForObjectByVariableArg() {
		printTitle("getForObjectByVariableArg");
		String response = restTemplate.getForObject(
				"http://localhost:8080/spring4-chap17-s/stores/{storeId}",
				String.class, "1");
		System.out.println(response);
		Store store = restTemplate.getForObject(
				"http://localhost:8080/spring4-chap17-s/stores/{storeId}", Store.class,
				"1");
		System.out.println(store);
	}

	private static void getForObjectByVariableMap() {
		printTitle("getForObjectByVariableMap");
		Map<String, Object> pathVariableMap = new HashMap<>();
		pathVariableMap.put("storeId", 1L);

		Store store2 = restTemplate.getForObject(
				"http://localhost:8080/spring4-chap17-s/stores/{storeId}",
				Store.class,
				pathVariableMap);
		System.out.println(store2);
	}

	private static void postForLocation() {
		printTitle("postForLocation");
		Store store = new Store();
		store.setName("새로운 가게");
		URI uri = restTemplate.postForLocation("http://localhost:8080/spring4-chap17-s/stores", store);
		System.out.println(uri.toString());
	}

	private static void printTitle(String title) {
		System.out.println("\n\n");
		System.out.println("[" + title + "]");
	}

	private static void exchange() {
		printTitle("exchange");

		// getForEntity를 exchage를 이용해서 구현한 코드
		URI uri = UriComponentsBuilder.newInstance()
				.scheme("http")
				.host("localhost")
				.port(8080)
				.path("/spring4-chap17-s/stores/{storeId}/items/{itemId}")
				.build()
				.expand("1", "I100").encode()
				.toUri();

		HttpHeaders headers = new HttpHeaders();
		headers.add("AUTHKEY", "mykey");
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Void> requestEntity = new HttpEntity<>((Void) null, headers);

		ResponseEntity<Item> itemResponse = restTemplate.exchange(
				uri, HttpMethod.GET, requestEntity, Item.class);
		Item item = itemResponse.getBody();
		System.out.println(item);

		// postForLocation을 exchage를 이용해서 구현한 코드
		HttpEntity<Store> requestEntity2 =
				new HttpEntity<>(new Store("새로운 가게 2"), headers);

		ResponseEntity<Void> postResponse = restTemplate.exchange(
				"http://localhost:8080/spring4-chap17-s/stores",
				HttpMethod.POST, requestEntity2, Void.class);
		URI newStoreUri = postResponse.getHeaders().getLocation();
		System.out.println(newStoreUri);
	}

	private static void catchException() {
		printTitle("catchException");
		try {
			restTemplate.getForObject(
					"http://localhost:8080/spring4-chap17-s/stores/{storeId}/items/{itemId}",
					String.class, "0A", "I100");
		} catch (RestClientException e) {
			e.printStackTrace();
		}
	}

}
