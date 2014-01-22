package net.madvirus.spring4.chap05;

public class DataCollector implements ThresholdRequired {

	private int threshold;

	@Override
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public int getThreshold() {
		return threshold;
	}

}
