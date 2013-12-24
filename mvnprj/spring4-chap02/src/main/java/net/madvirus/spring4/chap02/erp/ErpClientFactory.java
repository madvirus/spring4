package net.madvirus.spring4.chap02.erp;

public abstract class ErpClientFactory {
	private static ErpClientFactory factory = new DefaultErpClientFactory();

	public static ErpClientFactory instance() {
		return factory;
	}

	protected ErpClientFactory() {
	}
	
	public abstract ErpClient create();
}
