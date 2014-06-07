package net.madvirus.spring4.chap15.hr.web;

import net.madvirus.spring4.chap15.hr.model.Employee;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class NewEmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> klass) {
		return klass == Employee.class;
	}

	@Override
	public void validate(Object object, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "number", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmpty(errors, "joinedDate", "required");
	}

}
