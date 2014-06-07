package net.madvirus.spring4.chap15.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BooleanCondition implements Condition {
	private String condition;
	private List<Object> values;

	public BooleanCondition(String condition, Object value) {
		this.condition = condition;
		this.values = Arrays.asList(value);
	}

	@Override
	public String getQuery() {
		return condition;
	}

	@Override
	public List<Object> getParams() {
		return Collections.unmodifiableList(values);
	}

	@Override
	public boolean isJunction() {
		return false;
	}

}
