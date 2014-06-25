package net.madvirus.spring4.chap17;

public class Store {

	private Long id;
	private String name;

	public Store() {
	}

	public Store(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
