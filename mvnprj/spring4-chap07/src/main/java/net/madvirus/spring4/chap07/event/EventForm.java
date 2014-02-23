package net.madvirus.spring4.chap07.event;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class EventForm {

	private String name;
	private EventType type;

	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date beginDate;
	@DateTimeFormat(pattern = "yyyyMMdd")
	private Date endDate;

	private String target;

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

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date from) {
		this.beginDate = from;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date to) {
		this.endDate = to;
	}
	
	public boolean hasPeriod() {
		return beginDate != null || endDate != null;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public boolean isEndDateBeforeNow() {
		return endDate != null && endDate.before(new Date());
	}

	public boolean isBeginDateAfterEndDate() {
		if (beginDate != null && endDate != null) {
			return beginDate.after(endDate);
		}
		return false;
	}

}
