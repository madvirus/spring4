package net.madvirus.spring4.chap02.shop;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import net.madvirus.spring4.chap02.search.SearchClientFactory;
import net.madvirus.spring4.chap02.search.SearchDocument;

@Component
public class ProductService {

	private SearchClientFactory searchClientFactory;

	@Resource(name = "productSearchClientFactory")
	public void setSearchClientFactory(SearchClientFactory searchClientFactory) {
		this.searchClientFactory = searchClientFactory;
	}

	public void createProduct(ProductInfo pi) {
		searchClientFactory.create().addDocument(toSearchDocument(pi));
	}

	private SearchDocument toSearchDocument(ProductInfo pi) {
		return new SearchDocument();
	}
}
