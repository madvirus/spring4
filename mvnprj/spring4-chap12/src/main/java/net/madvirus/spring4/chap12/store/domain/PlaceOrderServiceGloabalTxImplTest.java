package net.madvirus.spring4.chap12.store.domain;

import org.springframework.beans.factory.annotation.Autowired;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:globalTx.xml"})
//@TransactionConfiguration(defaultRollback = false)
public class PlaceOrderServiceGloabalTxImplTest {

	@Autowired
	private PlaceOrderService placeOrderService;

//	@Test
	public void order() {
		PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
		orderRequest.setItemId(1);
		orderRequest.setAddress("");
		PurchaseOrderResult orderResult = placeOrderService.order(orderRequest);
//		assertNotNull(orderResult);
	}
}
