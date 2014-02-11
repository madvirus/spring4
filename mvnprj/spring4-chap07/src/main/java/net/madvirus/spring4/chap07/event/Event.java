package net.madvirus.spring4.chap07.event;

public class Event {

	private Long id;
	private String name;

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

	public static Event create(Long id, String name) {
		Event result = new Event();
		result.id = id;
		result.name = name;
		return result;
	}

}
