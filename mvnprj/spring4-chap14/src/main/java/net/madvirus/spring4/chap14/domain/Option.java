package net.madvirus.spring4.chap14.domain;

public class Option<T> {

	private T value;

	public Option(T value) {
		this.value = value;
	}
	
	public boolean hasValue() {
		return value != null;
	}
	
	public T get() {
		if (value == null) throw new IllegalStateException("no value");
		return value;
	}
}
