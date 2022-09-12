package com.library.management.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Books")
public class Books {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long bookId;

	@Column(name = "isbnNumber", length = 50, nullable = false, unique = true)
	private String isbnNumber;

	@Column(name = "title", length = 100, nullable = false)
	private String title;

	@Column(name = "edition", length = 100, nullable = false)
	private String edition;

	@Column(name = "author", length = 100, nullable = false)
	private String author;

	@Column(name = "publisher", length = 100, nullable = false)
	private String publisher;

	@Column(name = "category", length = 50, nullable = false)
	private String category;

	@Column(name = "price", nullable = false)
	private double price;

	@Column(name = "copies", nullable = false)
	private int copies;

	@Column(name = "createdBy", nullable = false)
	private long createdBy;

	@Column(name = "modifiedBy", nullable = false)
	private long modifiedBy;

	@Column(name = "createdOn", nullable = false)
	private long createdOn;

	@Column(name = "modifiedOn", nullable = false)
	private long modifiedOn;
	
	@ManyToOne
	private User user;

	public Books(long bookId, String isbnNumber, String title, String edition, String author, String publisher,
			String category, double price, int copies, long createdBy, long modifiedBy, long createdOn,
			long modifiedOn) {
		super();
		this.bookId = bookId;
		this.isbnNumber = isbnNumber;
		this.title = title;
		this.edition = edition;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
		this.price = price;
		this.copies = copies;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}

	public Long getBookId() {
		return bookId;
	}

	public User getUser() {
		return user;
	}


}
