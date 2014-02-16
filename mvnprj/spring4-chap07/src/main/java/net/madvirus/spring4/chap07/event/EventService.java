package net.madvirus.spring4.chap07.event;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class EventService {

	private SortedMap<Long, Event> eventMap = new TreeMap<>();

	public EventService() {
		eventMap.put(1L, Event.create(1L, "JCO 객체 지향 발들이기"));
		eventMap.put(2L, Event.create(2L, "Okjsp 생존 테스트 프로그래밍"));
		eventMap.put(3L, Event.create(3L, "아마존 AWS 구축 세미나"));
		eventMap.put(4L, Event.create(4L, "플랫폼 데이"));
	}

	public Event getEvent(Long eventId) {
		return eventMap.get(eventId);
	}

	public List<Event> getRecommendedEventService() {
		List<Event> recommendList = new ArrayList<>();
		recommendList.add(eventMap.get(1L));
		return recommendList;

	}

	public List<Event> getOpenedEventList() {
		return new ArrayList<Event>(eventMap.values());
	}

}
