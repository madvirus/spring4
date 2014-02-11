package net.madvirus.spring4.chap07.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {

	@RequestMapping("/event/list")
	public String list(Model model) {
		List<Event> eventList = getOpenedEventList();
		model.addAttribute("eventList", eventList);
		return "event/list";
	}

	@RequestMapping("/event/list2")
	public ModelAndView list2() {
		List<Event> eventList = getOpenedEventList();
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("event/list");
		modelView.addObject("eventList", eventList);
		return modelView;
	}

	private List<Event> getOpenedEventList() {
		List<Event> events = new ArrayList<>();
		events.add(Event.create(1L, "객체 지향 발들이기"));
		return events;
	}
}
