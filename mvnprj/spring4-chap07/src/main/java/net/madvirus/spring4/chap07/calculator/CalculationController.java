package net.madvirus.spring4.chap07.calculator;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculationController {

	@RequestMapping("/cal/add")
	public String add(
			@RequestParam("op1") int op1,
			@RequestParam("op2") int op2,
			Model model) {
		model.addAttribute("result", op1 + op2);
		return "cal/result";
	}

	@RequestMapping("/cal/divide")
	public String divide(Model model,
			@RequestParam("op1") int op1, @RequestParam("op2") int op2) {
		model.addAttribute("result", op1 / op2);
		return "cal/result";
	}

	@ExceptionHandler(RuntimeException.class)
	public String handleException(HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return "error/exception";
	}
}
