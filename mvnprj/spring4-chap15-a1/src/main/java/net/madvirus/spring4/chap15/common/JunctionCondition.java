package net.madvirus.spring4.chap15.common;

import java.util.LinkedList;
import java.util.List;

public abstract class JunctionCondition implements Condition {

	private List<Condition> conditions;

	public JunctionCondition(Condition... conditions) {
		this.conditions = new LinkedList<>();
		for (Condition con : conditions)
			this.conditions.add(con);
	}

	@Override
	public String getQuery() {
		String query = "";
		int i = 0;
		for (Condition con : conditions) {
			if (i > 0)
				query += " " + getJunctionString() + " ";
			if (con.isJunction())
				query += "(";
			query += con.getQuery();
			if (con.isJunction())
				query += ")";
			i++;
		}
		return query;
	}

	abstract protected String getJunctionString();

	@Override
	public List<Object> getParams() {
		List<Object> params = new LinkedList<>();
		for (Condition con : conditions)
			params.addAll(con.getParams());
		return params;
	}

	public JunctionCondition add(Condition condition) {
		conditions.add(condition);
		return this;
	}

	@Override
	public final boolean isJunction() {
		return true;
	}

	public final boolean hasConditions() {
		return !conditions.isEmpty();
	}

}
