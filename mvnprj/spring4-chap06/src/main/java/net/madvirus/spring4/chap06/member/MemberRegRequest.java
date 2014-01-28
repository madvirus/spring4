package net.madvirus.spring4.chap06.member;

public class MemberRegRequest {

	private String id;
	private String name;
	private String password;

	public MemberRegRequest(String id, String name, String password) {
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
