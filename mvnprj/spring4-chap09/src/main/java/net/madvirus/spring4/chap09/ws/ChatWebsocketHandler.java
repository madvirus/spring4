package net.madvirus.spring4.chap09.ws;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatWebsocketHandler extends TextWebSocketHandler {

	private Map<String, WebSocketSession> users = new HashMap<>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println(session.getId() + " 연결됨");
		users.put(session.getId(), session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println(session.getId() + " 연결 종료");
		users.remove(session.getId());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		System.out.println(session.getId() + " 메시지 수신: " + message.getPayload());
		for (WebSocketSession s : users.values()) {
			s.sendMessage(message);
			System.out.println(s.getId() + " 메시지 발송: " + message.getPayload());
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		exception.printStackTrace();
	}
}