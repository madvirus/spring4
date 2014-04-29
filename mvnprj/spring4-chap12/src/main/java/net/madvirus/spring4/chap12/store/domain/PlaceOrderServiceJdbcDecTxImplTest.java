package net.madvirus.spring4.chap12.store.domain;

import org.springframework.beans.factory.annotation.Autowired;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration({"classpath:jdbcDecTx.xml", "classpath:dataSource.xml"})
//@TransactionConfiguration(defaultRollback = false)
public class PlaceOrderServiceJdbcDecTxImplTest {

	@Autowired
	private PlaceOrderService placeOrderService;

//	@Test
	public void order() {
		PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
		orderRequest.setItemId(1);
		orderRequest.setAddress("주소");
		PurchaseOrderResult orderResult = placeOrderService.order(orderRequest);
//		assertNotNull(orderResult);
	}

}
