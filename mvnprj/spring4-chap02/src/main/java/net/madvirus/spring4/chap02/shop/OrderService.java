package net.madvirus.spring4.chap02.shop;

import net.madvirus.spring4.chap02.erp.ErpClient;
import net.madvirus.spring4.chap02.erp.ErpClientFactory;
import net.madvirus.spring4.chap02.erp.ErpOrderData;
import net.madvirus.spring4.chap02.search.SearchClientFactory;
import net.madvirus.spring4.chap02.search.SearchDocument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class OrderService {

	private ErpClientFactory erpClientFactory;

	private SearchClientFactory searchClientFactory;

	@Autowired
	public void setErpClientFactory(ErpClientFactory erpClientFactory) {
		this.erpClientFactory = erpClientFactory;
	}

	@Autowired
	@Qualifier("order")
	public void setSearchClientFactory(SearchClientFactory searchClientFactory) {
		this.searchClientFactory = searchClientFactory;
	}

	public void order(OrderInfo oi) {
		sendOrderInfoToErp(oi);
		addOrderInfoToSearch(oi);
	}

	private void sendOrderInfoToErp(OrderInfo oi) {
		ErpClient erpClient = erpClientFactory.create();
		erpClient.connect();
		erpClient.sendPurchaseInfo(toErpOrderData(oi));
		erpClient.close();
	}

	private ErpOrderData toErpOrderData(OrderInfo oi) {
		return new ErpOrderData();
	}

	private void addOrderInfoToSearch(OrderInfo oi) {
		searchClientFactory.create().addDocument(toSearchDocument(oi));
	}

	private SearchDocument toSearchDocument(OrderInfo oi) {
		return new SearchDocument();
	}
}
