package com.library.management.Service;

import java.util.List;

import com.library.management.Entity.Books;

public interface BookService {
	
    public List<Books> findAllBooks();
	
	public List<Books> searchBooks(String keyword);

	public Books findBookById(Long id);

	public void createBook(Books book);

	public void updateBook(Books book);

	public void deleteBook(Long id);

}
