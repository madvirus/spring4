package net.madvirus.spring4.chap18;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String greeting(@RequestParam("name") String name, Model model) {
		model.addAttribute("greeting",
				new Greeting("안녕하세요, " + name, new Name(name)));
		return "hello";
	}

	@RequestMapping("/hello.json")
	@ResponseBody
	public Greeting greetingJson(@RequestBody Name name) {
		return new Greeting("안녕하세요, " + name.getName(), name);
	}
}
