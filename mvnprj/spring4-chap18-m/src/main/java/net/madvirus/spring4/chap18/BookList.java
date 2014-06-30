package net.madvirus.spring4.chap18;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "book-list")
public class BookList {

	@XmlElement(name = "book")
	private List<Book> books;

	public BookList() {
	}

	public BookList(List<Book> books) {
		this.books = books;
	}

	public List<Book> getBooks() {
		return books;
	}

}
