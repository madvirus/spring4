package net.madvirus.spring4.chap15.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER")
public class Member {

	@Id
	@GeneratedValue
	@Column(name = "MEMBER_ID")
	private Long id;
	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "ENC_PASSWORD")
	private String encPassword;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "NAME")
	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCKER_ID")
	private Locker locker;

	protected Member() {
	}

	public Member(String userId, String plainPassword, String email, String name) {
		this.userId = userId;
		this.encPassword = encrypt(plainPassword);
		this.email = email;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public void changePassword(String oldPw, String newPw) {
		if (!matchPassword(oldPw))
			throw new WrongPasswordException();
		this.encPassword = encrypt(newPw);
	}

	public boolean matchPassword(String pw) {
		return encrypt(pw).equals(encPassword);
	}

	private String encrypt(String plainPw) {
		// 실제로는 제대로 된 암호화 사용
		return EncryptUtil.encrypt(plainPw);
	}

	public Locker getLocker() {
		return locker;
	}

}
