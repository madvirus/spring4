package net.madvirus.spring4.chap17;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class StoreController {

	private Map<Long, Store> storeMap = new HashMap<>();
	private Map<String, Item> itemMap = new HashMap<>();
	private long storeNextId;

	public StoreController() {
		storeMap.put(1L, new Store(1L, "L&L"));
		storeMap.put(2L, new Store(2L, "신풍"));
		storeNextId = 3L;
		itemMap.put("I100", new Item("I100", "삐까뻔쩍", 10000));
	}

	@RequestMapping(value = "/stores/{storeId}", method = RequestMethod.GET)
	@ResponseBody
	public Store store(@PathVariable("storeId") Long storeId, HttpServletResponse response) throws IOException {
		Store store = storeMap.get(storeId);
		if (store == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return store;
	}

	@RequestMapping(value = "/stores", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Store store, HttpServletResponse response) {
		Store newStore = new Store(storeNextId++, store.getName());
		storeMap.put(newStore.getId(), newStore);
		UriComponents uriComp = UriComponentsBuilder.newInstance()
				.scheme("http").host("localhost").port(8080)
				.path("/spring4-chap17-s/stores/{storeId}").build();
		UriComponents encodedUri = uriComp.expand(newStore.getId()).encode();
		response.setHeader("Location", encodedUri.toUriString());
	}

	@RequestMapping(value = "/stores/{storeId}/items/{itemId}", method = RequestMethod.GET)
	@ResponseBody
	public Item item(@PathVariable("storeId") Long storeId,
			@PathVariable("itemId") String itemId,
			HttpServletResponse response) throws IOException {
		Store store = storeMap.get(storeId);
		if (store == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		Item item = itemMap.get(itemId);
		if (item == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
		return item;
	}
}
