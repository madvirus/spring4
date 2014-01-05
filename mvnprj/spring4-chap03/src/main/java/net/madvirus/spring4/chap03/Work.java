package net.madvirus.spring4.chap03;

public class Work {
	public static enum WorkType {
		SINGLE
	}

	private long timeout;
	private WorkType type;
	private long order;

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public void setType(WorkType type) {
		this.type = type;
	}

	public void setOrder(long order) {
		this.order = order;
	}

	public long getOrder() {
		return order;
	}

	public void run() {
		System.out.printf("Work[timetoue=%d, type=%s, order=%d] executed\n", timeout, type, order);
	}

}
