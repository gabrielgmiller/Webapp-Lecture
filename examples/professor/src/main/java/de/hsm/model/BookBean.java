package de.hsm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import de.hsm.logic.Author;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String title;
	private String isbn13;
	private String publisher;
	private Integer numberOfPages;
	private LocalDate publishedDate;
	private String language;
	private BigDecimal price;
	private List<Author> authors = new ArrayList<>();
	private int authorId;

	public BookBean(String title, String isbn13, String publisher, Integer numberOfPages, 
			LocalDate publishedDate, String language, BigDecimal price) {
		this.title = title;
		this.isbn13 = isbn13;
		this.publisher = publisher;
		this.numberOfPages = numberOfPages;
		this.publishedDate = publishedDate;
		this.language = language;
		this.price = price;
	}

	public BookBean() {
	}

	public void addAuthor(Author author) {
		this.authors.add(author);
	}
	
	public Author getFirstAuthor() {
		if (!authors.isEmpty()) {
			return authors.get(0);
		}
		return new Author();
	}

}
