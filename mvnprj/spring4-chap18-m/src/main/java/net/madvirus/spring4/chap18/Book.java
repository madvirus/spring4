package net.madvirus.spring4.chap18;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "title", "price", "isbn" })
public class Book {

	private String title;
	private int price;
	private String isbn;

	public Book() {
	}

	public Book(String title, int price, String isbn) {
		this.title = title;
		this.price = price;
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	public String getIsbn() {
		return isbn;
	}

}
