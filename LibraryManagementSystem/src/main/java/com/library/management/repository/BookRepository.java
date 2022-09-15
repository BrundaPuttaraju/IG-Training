package com.library.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.management.Entity.Books;

@Repository
public interface BookRepository extends JpaRepository<Books, Long> {

	@Query(value = "select b from Books b where b.title = title")
	public List<Books> getBookByTitle(String title);

	@Query(value = "select b from Books b where b.author = author")
	public List<Books> getBookByAuthor(String author);

	@Query(value = "select b from Books b where b.publisher = publisher")
	public List<Books> getBookByPublisher(String publisher);

}
