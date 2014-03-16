package net.madvirus.spring4.chap09.mc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mc/simple")
public class SimpleConverterController {

	@RequestMapping(method = RequestMethod.GET)
	public String simpleForm() {
		return "mc/simple";
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String simple(@RequestBody String body) {
		return body;
	}

}