package com.library.management.Entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

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
	private long bookId;
	
	@Column(name = "transactionId", nullable = false)
	private long transactionId;

	@Column(name = "issuedBy", nullable = false)
	private long issuedBy;
	
	@Column(name = "status", length = 50, nullable = false)
	private String status;

	@Column(name = "modifiedBy", nullable = false)
	private long modifiedBy;
	
	@Column(name = "issuedTo", nullable = false)
	private long issuedTo;

	@Column(name = "issueDate")
	@CreationTimestamp
	private Timestamp issueDate;

	@Column(name = "returnDate")
	@CreationTimestamp
	private Timestamp returnDate;

	@Column(name = "createdOn")
	@CreationTimestamp
	private Timestamp createdOn;

	@Column(name = "modifiedOn")
	@CreationTimestamp
	private Timestamp modifiedOn;

	public BookIssueInfo(long bookId, long transactionId, long issuedBy, String status, long modifiedBy, long issuedTo,
			Timestamp issueDate, Timestamp returnDate, Timestamp createdOn, Timestamp modifiedOn) {
		super();
		this.bookId = bookId;
		this.transactionId = transactionId;
		this.issuedBy = issuedBy;
		this.status = status;
		this.modifiedBy = modifiedBy;
		this.issuedTo = issuedTo;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
	}
	
	

}
