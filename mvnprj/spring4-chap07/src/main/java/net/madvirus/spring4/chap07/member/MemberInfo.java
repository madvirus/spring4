package net.madvirus.spring4.chap07.member;

public class MemberInfo {

	private String id;
	private String name;
	private String email;
	private String password;
	private boolean allowNoti;

	public MemberInfo(String id, String name, String email, String password, boolean alloNoti) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.allowNoti = alloNoti;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public boolean isAllowNoti() {
		return allowNoti;
	}

	public boolean matchPassword(String inputPassword) {
		System.out.printf("암호 검사 = [%s] = [%s]\n", password, inputPassword);
		return password.equals(inputPassword);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAllowNoti(boolean allowNoti) {
		this.allowNoti = allowNoti;
	}

}
