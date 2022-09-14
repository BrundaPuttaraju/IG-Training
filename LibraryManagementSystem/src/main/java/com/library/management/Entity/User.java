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

	@Column(name = "user_type", length = 100, nullable = false)
	private String user_type;

	@Column(name = "email", length = 100, nullable = false)
	private String email;

	@Column(name = "first_name", length = 100, nullable = false)
	private String first_name;

	@Column(name = "last_name", length = 100, nullable = false)
	private String last_name;

	@Column(name = "phone_no", nullable = true)
	private long phone_no;

	@Column(name = "address", length = 100, nullable = false)
	private String address;

	@OneToMany(mappedBy = "user")
	private List<Books> books;

	public List<Books> getBooks() {
		return books;
	}
	

	public User(long userId, String userType, String email, String firstName, String lastName, long phoneNo,
			String address, List<Books> books) {
		super();
		this.userId = userId;
		this.user_type = userType;
		this.email = email;
		this.first_name = firstName;
		this.last_name = lastName;
		this.phone_no = phoneNo;
		this.address = address;
		this.books = books;
	}
	

	public User() {
		super();
	}


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return user_type;
	}

	public void setUserType(String userType) {
		this.user_type = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String lastName) {
		this.last_name = lastName;
	}

	public long getPhoneNo() {
		return phone_no;
	}

	public void setPhoneNo(long phoneNo) {
		this.phone_no = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBooks(List<Books> books) {
		this.books = books;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userType=" + user_type + ", email=" + email + ", firstName=" + first_name
				+ ", lastName=" + last_name + ", phoneNo=" + phone_no + ", address=" + address + ", books=" + books + "]";
	}
	
	

}
