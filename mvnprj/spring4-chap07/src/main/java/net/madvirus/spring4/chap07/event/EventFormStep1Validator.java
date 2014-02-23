package net.madvirus.spring4.chap07.event;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventFormStep1Validator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return EventForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "type", "required");
		EventForm eventForm = (EventForm) target;
		if (eventForm.isEndDateBeforeNow()) {
			errors.rejectValue("endDate", "badEndDate");
		}
		if (eventForm.isBeginDateAfterEndDate()) {
			errors.rejectValue("beginDate", "badBeginDate");
		}
	}

}
