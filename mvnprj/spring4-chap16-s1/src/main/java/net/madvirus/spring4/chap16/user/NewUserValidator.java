package net.madvirus.spring4.chap16.user;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class NewUserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return NewUser.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirm", "required");
		NewUser newUser = (NewUser) target;
		if (!newUser.isPasswordAndConfirmSame())
			errors.rejectValue("confirm", "notSame");
	}

}
