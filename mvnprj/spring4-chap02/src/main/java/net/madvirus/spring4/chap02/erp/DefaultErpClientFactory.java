package net.madvirus.spring4.chap02.erp;

class DefaultErpClientFactory extends ErpClientFactory {

	@Override
	public ErpClient create() {
		return new ErpClient() {
			@Override
			public void connect() {
				System.out.println("연결함");
			}

			@Override
			public void close() {
				System.out.println("연결 끊음");
			}
		};
	}

}
