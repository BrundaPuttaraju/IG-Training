package com.library.management.Service;

import java.util.List;
import java.util.Optional;

import com.library.management.Entity.Books;

public interface BookService {
	
    public List<Books> getAllBooks();
	
    public List<Books> getBookByTitle(String title);
    
    public List<Books> getBookByAuthor(String author);
    
    public List<Books> getBookByPublisher(String publisher);

	public Optional<Books> getBookById(Long id);

	public Books createBook(long uid, Books book);

	public Books updateBook(Books book);

	public void deleteBook(Long id);

}
