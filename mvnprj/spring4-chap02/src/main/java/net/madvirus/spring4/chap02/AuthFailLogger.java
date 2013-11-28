package net.madvirus.spring4.chap02;

public class AuthFailLogger {

	private int thresold;
	private int failCounts;
	
	public void insertBadPw(String userId, String inputPw) {
		System.out.printf("AuthFail [type=badpw, userid=%s, pw=%s\n", userId, inputPw);
		failCounts++;
		if (thresold > 0 && failCounts > thresold) {
			notifyTooManyFail();
			failCounts = 0;
		}
	}

	private void notifyTooManyFail() {
		System.out.println("너무 많은 로그인 시도 실패");
	}

	public void setThresold(int thresold) {
		this.thresold = thresold;
	}

}
