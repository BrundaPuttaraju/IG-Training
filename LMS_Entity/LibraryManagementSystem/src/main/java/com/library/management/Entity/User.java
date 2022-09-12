package com.library.management.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "User_details")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@Column(name = "userType", length = 100, nullable = false)
	private String userType;

	@Column(name = "email", length = 100, nullable = false)
	private String email;

	@Column(name = "firstName", length = 100, nullable = false)
	private String firstName;

	@Column(name = "lastName", length = 100, nullable = false)
	private String lastName;

	@Column(name = "phoneNo", nullable = true)
	private long phoneNo;

	@Column(name = "address", length = 100, nullable = false)
	private String address;

	@OneToMany(mappedBy = "user")
	private List<Books> books;
	
	public List<Books> getBooks() {
		return books;
	}

	public User(long userId, String userType, String email, String firstName, String lastName, long phoneNo,
			String address) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.address = address;
	}

	

}
