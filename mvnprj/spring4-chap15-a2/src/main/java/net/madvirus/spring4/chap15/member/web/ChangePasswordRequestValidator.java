package net.madvirus.spring4.chap15.member.web;

import net.madvirus.spring4.chap15.member.application.ChangePasswordRequest;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ChangePasswordRequestValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == ChangePasswordRequest.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "memberId", "required");
		ValidationUtils.rejectIfEmpty(errors, "currentPassword", "required");
		ValidationUtils.rejectIfEmpty(errors, "newPassword", "required");
	}

}
