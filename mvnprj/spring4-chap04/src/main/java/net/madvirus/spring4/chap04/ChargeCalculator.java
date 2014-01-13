package net.madvirus.spring4.chap04;

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
		System.out.printf("요금 계산[batchSize=%d]\n", batchSize);
	}
}
