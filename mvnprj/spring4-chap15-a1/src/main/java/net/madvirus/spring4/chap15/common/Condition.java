package net.madvirus.spring4.chap15.common;

import java.util.List;

public interface Condition {
	public String getQuery();
	public List<Object> getParams();
	public boolean isJunction();
}
