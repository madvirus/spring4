package net.madvirus.spring4.chap17.restclient;

public class Store {

	private Long id;
	private String name;

	public Store() {
	}

	public Store(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", name=" + name + "]";
	}

}
