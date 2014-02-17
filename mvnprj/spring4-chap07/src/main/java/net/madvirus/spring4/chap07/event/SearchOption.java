package net.madvirus.spring4.chap07.event;

import java.util.Collection;

public class SearchOption {

	private Collection<EventType> types;
	private boolean allType;

	public Collection<EventType> getTypes() {
		return types;
	}

	public void setTypes(Collection<EventType> types) {
		this.types = types;
	}

	public boolean isAllType() {
		return allType || types == null;
	}

	public void setAllType(boolean allType) {
		this.allType = allType;
	}

}
