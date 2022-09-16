package com.library.management.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "BookIssueInfo")
public class BookIssueInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long transactionId;
	
	@ManyToOne
    @JoinColumn(name = "bookId")
	private Books bookId;
	
	@ManyToOne
    @JoinColumn(name = "userId")
    private User userId;
	
	private String status;

	private long modifiedBy;
	
	@ManyToOne
    @JoinColumn(name = "issued_To")
	private User issued_To;

	@ManyToOne
    @JoinColumn(name = "issued_By")
    private User issued_By;

	private LocalDate issueDate;

	private LocalDate returnDate;

	private LocalDateTime createdOn;

	private LocalDateTime modifiedOn;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public Books getBookId() {
		return bookId;
	}

	public void setBookId(Books bookId) {
		this.bookId = bookId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public User getIssued_To() {
		return issued_To;
	}

	public void setIssued_To(User issued_To) {
		this.issued_To = issued_To;
	}

	public User getIssued_By() {
		return issued_By;
	}

	public void setIssued_By(User issued_By) {
		this.issued_By = issued_By;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public BookIssueInfo(long transactionId, Books bookId, User userId, String status, long modifiedBy, User issued_To,
			User issued_By, LocalDate issueDate, LocalDate returnDate, LocalDateTime createdOn,
			LocalDateTime modifiedOn) {
		super();
		this.transactionId = transactionId;
		this.bookId = bookId;
		this.userId = userId;
		this.status = status;
		this.modifiedBy = modifiedBy;
		this.issued_To = issued_To;
		this.issued_By = issued_By;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}

	public BookIssueInfo() {
		super();
	}

	
	
	
}