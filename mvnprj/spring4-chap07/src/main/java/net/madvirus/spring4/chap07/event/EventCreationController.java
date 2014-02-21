package net.madvirus.spring4.chap07.event;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("eventForm")
public class EventCreationController {

	@RequestMapping("/event/creattion/step1")
	public String step1(@ModelAttribute("eventForm") EventForm formData) {
		return "event/creationStep1";
	}
	
	@RequestMapping(value="/event/creattion/step2", method=RequestMethod.POST)
	public String step2(@ModelAttribute("eventForm") EventForm formData) {
		return "event/creationStep2";
	}
	
	@RequestMapping(value="/event/creattion/step3", method=RequestMethod.POST)
	public String step3(@ModelAttribute("eventForm") EventForm formData) {
		return "event/creationStep3";
	}
	
	@RequestMapping(value="/event/creattion/done", method=RequestMethod.POST)
	public String done(@ModelAttribute("eventForm") EventForm formData) {
		return "event/done";
	}
	
	
}
