package net.madvirus.spring4.chap07.quickstart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController2 {

	@RequestMapping("/hello.do2")
	public String hello(Model model) {
		model.addAttribute("greeting", "반갑습니다.");
		return "hello";
	}
}
