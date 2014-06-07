package net.madvirus.spring4.chap15.common;


public class OrCondition extends JunctionCondition {

	public OrCondition(Condition... conditions) {
		super(conditions);
	}

	@Override
	protected String getJunctionString() {
		return "or";
	}

}
