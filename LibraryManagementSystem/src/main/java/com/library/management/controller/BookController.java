package com.library.management.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.library.management.Entity.Books;
import com.library.management.Service.BookService;
import com.library.management.exception.BookNotFoundException;

@RestController
@RequestMapping("/api1")
public class BookController {

	private static final Logger log = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<List<Books>> getAllBooks() {
		log.info("fetching all the Books");
		List<Books> book = bookService.getAllBooks();
		return new ResponseEntity<List<Books>>(book, HttpStatus.OK);
	}

	@GetMapping("/title/{title}")
	public ResponseEntity<List<Books>> getBookByTitle(@PathVariable(value="title") String title) throws BookNotFoundException {
		log.info("fetching book by using the title");	
		List<Books> bookByTitle = bookService.getBookByTitle(title);
		return new ResponseEntity<List<Books>>(bookByTitle, HttpStatus.OK);
	}

	@GetMapping("/author/{author}")
	public ResponseEntity<List<Books>> getBookByAuthor(@PathVariable(value="author") String author) throws BookNotFoundException {
		log.info("fetching book by using author name");
		List<Books> bookByAuthor = bookService.getBookByAuthor(author);
		return new ResponseEntity<List<Books>>(bookByAuthor, HttpStatus.OK);
	}

	@GetMapping("/publisher/{publisher}")
	public ResponseEntity<List<Books>> getBookByPublisher(@PathVariable(value="pulisher") String publisher )
			throws BookNotFoundException {
		log.info("fetching book with the help of publisher");
		List<Books> bookByPublisher = bookService.getBookByPublisher(publisher);
		return new ResponseEntity<List<Books>>(bookByPublisher, HttpStatus.OK);
	}

	@PostMapping("/books/{uid}")
	public ResponseEntity<Books> saveBook(@PathVariable(value ="uid") Long uid, @RequestBody Books book) {
		log.info("adding the book record");
		return new ResponseEntity<Books>(bookService.createBook(uid, book), HttpStatus.OK);
				
	}

	@PutMapping("/{id}")
	public ResponseEntity<Books> updateBook(@PathVariable("id") long id, @RequestBody Books book)
			throws BookNotFoundException {
		log.info("updating the book record");
		book.setBookId(id);
		return ResponseEntity.ok().body(this.bookService.updateBook(book));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") long id) throws BookNotFoundException {
		log.info("deleting the book by id");
		bookService.deleteBook(id);
		return new ResponseEntity<String>("Book deleted successfully ", HttpStatus.OK);
	}

}
