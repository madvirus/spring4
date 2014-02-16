package net.madvirus.spring4.chap07.search;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

	@RequestMapping("/search")
	public String search(@RequestParam(value = "q", defaultValue="") String query,
			Model model) {
		System.out.println("검색어: " + query);
		return "search/result";
	}
}
