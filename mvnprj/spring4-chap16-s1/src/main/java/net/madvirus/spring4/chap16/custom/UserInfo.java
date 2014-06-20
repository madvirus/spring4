package net.madvirus.spring4.chap16.custom;

public class UserInfo {

	private String id;
	private String name;
	private String password;

	public UserInfo(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

}
