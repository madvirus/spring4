package net.madvirus.spring4.chap07.event;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class EventService {

	private SortedMap<Long, Event> eventMap = new TreeMap<>();

	public EventService() {
		eventMap.put(1L, Event.create(1L, "JCO 객체 지향 발들이기", EventType.CONFERENCE));
		eventMap.put(2L, Event.create(2L, "Okjsp 생존 테스트 프로그래밍", EventType.CONFERENCE));
		eventMap.put(3L, Event.create(3L, "강남 스타일 플래시 몹", EventType.FLASHMOB));
		eventMap.put(4L, Event.create(4L, "태극 플래시 몹", EventType.FLASHMOB));
		eventMap.put(5L, Event.create(5L, "플랫폼 데이", EventType.CONFERENCE));
		eventMap.put(6L, Event.create(6L, "동춘 서커스", EventType.CIRCUS));
	}

	public Event getEvent(Long eventId) {
		return eventMap.get(eventId);
	}

	public List<Event> getRecommendedEventService() {
		List<Event> recommendList = new ArrayList<>();
		recommendList.add(eventMap.get(1L));
		return recommendList;

	}

	public List<Event> getOpenedEventList(SearchOption option) {
		List<Event> result = new ArrayList<>();
		for (Event event : eventMap.values()) {
			if (option.isAllType()) {
				result.add(event);
			} else {
				for (EventType type : option.getTypes()) {
					if (type == event.getType()) {
						result.add(event);
						break;
					}
				}
			}
		}
		return result;
	}

}
