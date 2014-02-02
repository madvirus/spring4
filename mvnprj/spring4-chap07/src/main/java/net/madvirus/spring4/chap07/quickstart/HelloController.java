package net.madvirus.spring4.chap07.quickstart;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello.do")
	public String hello(ModelMap model) {
		model.addAttribute("greeting", "안녕하세요");
		return "hello";
	}
}
