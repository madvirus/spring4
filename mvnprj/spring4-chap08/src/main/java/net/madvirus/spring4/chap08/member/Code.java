package net.madvirus.spring4.chap08.member;

public class Code {

	private String code;
	private String label;

	public Code(String code, String name) {
		this.code = code;
		this.label = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String name) {
		this.label = name;
	}

}
