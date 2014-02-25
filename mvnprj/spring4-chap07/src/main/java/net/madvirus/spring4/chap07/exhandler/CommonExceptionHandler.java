package net.madvirus.spring4.chap07.exhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("net.madvirus.spring4.chap07")
public class CommonExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String handleException() {
		return "error/commonException";
	}
}
