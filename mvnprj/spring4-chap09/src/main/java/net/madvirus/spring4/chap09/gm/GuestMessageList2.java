package net.madvirus.spring4.chap09.gm;

import java.util.List;

public class GuestMessageList2 {

	private List<GuestMessage> messages;

	public GuestMessageList2(List<GuestMessage> messages) {
		this.messages = messages;
	}

	public List<GuestMessage> getMessages() {
		return messages;
	}

}
