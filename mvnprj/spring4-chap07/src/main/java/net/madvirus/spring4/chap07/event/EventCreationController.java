package net.madvirus.spring4.chap07.event;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("eventForm")
public class EventCreationController {

	private static final String EVENT_CREATION_STEP1 = "event/creationStep1";
	private static final String EVENT_CREATION_STEP2 = "event/creationStep2";
	private static final String EVENT_CREATION_STEP3 = "event/creationStep3";
	private static final String EVENT_CREATION_DONE = "event/creationDone";

//	@RequestMapping("/newevent/step1")
//	public String step1(Model model) {
//		model.addAttribute("eventForm", new EventForm());
//		return EVENT_CREATION_STEP1;
//	}

	@ModelAttribute("eventForm")
	public EventForm formData() {
		return new EventForm();
	}

	@RequestMapping("/newevent/step1")
	public String step1() {
		return EVENT_CREATION_STEP1;
	}
		
	@RequestMapping(value = "/newevent/step2", method = RequestMethod.POST)
	public String step2(@ModelAttribute("eventForm") EventForm formData, BindingResult result) {
		new EventFormStep1Validator().validate(formData, result);
		if (result.hasErrors())
			return EVENT_CREATION_STEP1;
		return EVENT_CREATION_STEP2;
	}

	@RequestMapping(value = "/newevent/step2", method = RequestMethod.GET)
	public String step2FromStep3(@ModelAttribute("eventForm") EventForm formData) {
		return EVENT_CREATION_STEP2;
	}

	@RequestMapping(value = "/newevent/step3", method = RequestMethod.POST)
	public String step3(@ModelAttribute("eventForm") EventForm formData, BindingResult result) {
		ValidationUtils.rejectIfEmpty(result, "target", "required");
		if (result.hasErrors())
			return EVENT_CREATION_STEP2;
		return EVENT_CREATION_STEP3;
	}

	@RequestMapping(value = "/newevent/done", method = RequestMethod.POST)
	public String done(@ModelAttribute("eventForm") EventForm formData, SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return EVENT_CREATION_DONE;
	}

}
