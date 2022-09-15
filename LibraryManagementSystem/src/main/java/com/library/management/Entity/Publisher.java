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
@Table(name = "Publisher")
public class Publisher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long publisherId;

	@Column(name = "publicationYear")
	@CreationTimestamp
	private Timestamp publicationYear;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	public Publisher(long publisherId, Timestamp publicationYear, String name) {
		super();
		this.publisherId = publisherId;
		this.publicationYear = publicationYear;
		this.name = name;
	}

}
