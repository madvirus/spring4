package net.madvirus.spring4.chap16.user;

public class NewUser {
	private String name;
	private String password;
	private String confirm;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public boolean isPasswordAndConfirmSame() {
		return password.equals(confirm);
	}

}
