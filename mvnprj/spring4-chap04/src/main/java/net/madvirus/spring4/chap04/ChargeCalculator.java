package net.madvirus.spring4.chap04;

import java.sql.Connection;

public class ChargeCalculator {

	private int batchSize;
	private ConnectionProvider connectionProvider;

	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}

	public void setConnectionProvider(ConnectionProvider connectionProvider) {
		this.connectionProvider = connectionProvider;
	}

	public void calculate() {
		System.out.printf("ChargeCalculator: 요금 계산[batchSize=%d]\n", batchSize);
		Connection conn = connectionProvider.getConnection();
		System.out.println("ChargeCalculator: DB 연결 구함: " + conn);
	}
}
