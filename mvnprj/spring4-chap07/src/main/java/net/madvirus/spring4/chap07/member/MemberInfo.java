package net.madvirus.spring4.chap07.member;

public class MemberInfo {

	private String id;
	private String name;

	public MemberInfo(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
