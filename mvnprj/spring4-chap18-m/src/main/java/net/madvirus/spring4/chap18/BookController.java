package net.madvirus.spring4.chap18;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {

	@RequestMapping(value = "/books.json", produces = "application/json; charset=utf-8")
	@ResponseBody
	public BookList booksJson() {
		return createBookList();
	}

	private BookList createBookList() {
		return new BookList(Arrays.asList(
				books("제목1", 1000, "000000"),
				books("제목2", 2000, "000001"),
				books("제목3", 3000, "000004")
				));
	}

	@RequestMapping(value = "/books.xml", produces = "application/xml; charset=utf-8")
	@ResponseBody
	public BookList booksXml() {
		return createBookList();
	}

	private Book books(String title, int price, String isbn) {
		return new Book(title, price, isbn);
	}
}
