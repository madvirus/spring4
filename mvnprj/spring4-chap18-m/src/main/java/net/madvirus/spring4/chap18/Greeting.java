package net.madvirus.spring4.chap18;

public class Greeting {
	private String greeting;
	private Name name;

	public Greeting(String greeting, Name name) {
		this.greeting = greeting;
		this.name = name;
	}

	public String getGreeting() {
		return greeting;
	}

	public Name getName() {
		return name;
	}

}