package com.library.management.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.management.Entity.Books;
import com.library.management.Entity.User;
import com.library.management.Service.BookService;
import com.library.management.exception.BookNotFoundException;
import com.library.management.repository.BookRepository;
import com.library.management.repository.UserRepository;

@Service
public class BookServiceImpl implements BookService {

	private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
    private UserRepository userRepository;
	

	@Override
	public List<Books> getAllBooks() {
		log.info("fetching all the books");
		return bookRepository.findAll();
	}

	@Override
	public List<Books> getBookByTitle(String title) {
		log.info("fetching the book by title");
		List<Books> bookTitle = bookRepository.getBookByTitle(title);
		if (bookTitle != null) {
			return bookTitle;
		} else {
			throw new BookNotFoundException("Book not found with the specified topic in the library: " + title);
		}
	}

	@Override
	public List<Books> getBookByAuthor(String author) {
		log.info("fetching the book by author");
		List<Books> authorname = bookRepository.getBookByAuthor(author);
		if (authorname != null) {
			return authorname;
		} else {
			throw new BookNotFoundException("Book not found with the specified author : " + author);
		}
	}

	@Override
	public List<Books> getBookByPublisher(String publisher) {
		log.info("fetching the book by publisher");
		List<Books> publisherName = bookRepository.getBookByPublisher(publisher);
		if (publisherName != null) {
			return publisherName;
		} else {
			throw new BookNotFoundException("Book not found with the specified publisher : " + publisher);
		}
	}

	@Override
	public Optional<Books> getBookById(Long id) {
		log.info("fetching the book by specified id");
		Optional<Books> books = bookRepository.findById(id);
		if (books.isPresent()) {
			return Optional.of(books.get());
		} else {
			throw new BookNotFoundException("Book not found with the specified publisher with specified id:" + id);
		}
	}

	@Override
	public Books createBook(long uid, Books book) {
		log.info("adding the book details");
		User userid = userRepository.findById(uid).get();
		book.setCreatedBy(userid);
        book.setModifiedBy(userid);
		return bookRepository.save(book);
	}

	@Override
	public Books updateBook(Books book) {
		log.info("updating the book details");
		Books books = bookRepository.findById(book.getBookId())
				.orElseThrow(() -> new BookNotFoundException("Book not found with id : " + book.getBookId()));
		books.setBookId(book.getBookId());
		books.setAuthor(book.getAuthor());
		books.setCategory(book.getCategory());
		books.setCopies(book.getCopies());
		books.setEdition(book.getEdition());
		books.setPrice(book.getPrice());
		return bookRepository.save(books);
	}

	@Override
	public void deleteBook(Long id) {
		log.info("deleting the book details by id");
		Optional<Books> book = this.bookRepository.findById(id);

        if (book.isPresent()) {
            this.bookRepository.delete(book.get());
        } else {
            throw new BookNotFoundException("Book not found with id : " + id);
        }

	}

}
