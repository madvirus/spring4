package net.madvirus.spring4.chap07.event;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/event")
public class EventController {
	private static final String REDIRECT_EVENT_LIST = "redirect:/event/list";
	private EventService eventService;

	public EventController() {
		eventService = new EventService();
	}

	@ModelAttribute("recEventList")
	public List<Event> recommend() {
		return eventService.getRecommendedEventService();
	}

	@RequestMapping("/list")
	public String list(Model model) {
		List<Event> eventList = getOpenedEventList();
		model.addAttribute("eventList", eventList);
		return "event/list";
	}

	@RequestMapping("/detail")
	public String list(HttpServletRequest request, Model model) throws IOException {
		String id = request.getParameter("id");
		if (id == null)
			return REDIRECT_EVENT_LIST;
		Long eventId = null;
		try {
			eventId = Long.parseLong(id);
		} catch (NumberFormatException e) {
			return REDIRECT_EVENT_LIST;
		}
		Event event = getEvent(eventId);
		if (event == null)
			return REDIRECT_EVENT_LIST;

		model.addAttribute("event", event);
		return "event/detail";
	}

	private Event getEvent(Long eventId) {
		return eventService.getEvent(eventId);
	}

	@RequestMapping("/list2")
	public ModelAndView list2() {
		List<Event> eventList = getOpenedEventList();
		ModelAndView modelView = new ModelAndView();
		modelView.setViewName("event/list");
		modelView.addObject("eventList", eventList);
		return modelView;
	}

	@RequestMapping("/detail2")
	public String list2(@RequestParam("id") long eventId, Model model) {
		Event event = getEvent(eventId);
		if (event == null)
			return REDIRECT_EVENT_LIST;
		model.addAttribute("event", event);
		return "event/detail";
	}

	private List<Event> getOpenedEventList() {
		return eventService.getOpenedEventList();
	}
}
