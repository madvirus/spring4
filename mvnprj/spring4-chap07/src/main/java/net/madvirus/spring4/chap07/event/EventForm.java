package net.madvirus.spring4.chap07.event;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EventForm {

	private String name;
	private EventType type;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date from;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date to;

	private String[] memberGrardes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public String[] getMemberGrardes() {
		return memberGrardes;
	}

	public void setMemberGrardes(String[] memberGrardes) {
		this.memberGrardes = memberGrardes;
	}

}
