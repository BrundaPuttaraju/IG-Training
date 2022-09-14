package com.library.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.management.Entity.Books;
import com.library.management.Entity.User;

public interface BookRepository extends JpaRepository<Books, Long>{

	
	

}
