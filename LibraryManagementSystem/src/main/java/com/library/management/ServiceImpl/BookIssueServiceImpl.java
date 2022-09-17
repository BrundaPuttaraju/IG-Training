package com.library.management.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.management.Entity.BookIssueInfo;
import com.library.management.Entity.Books;
import com.library.management.Entity.User;
import com.library.management.Service.BookIssueService;
import com.library.management.exception.BookIssuedInfoNotFoundException;
import com.library.management.repository.BookIssueInfoRepository;
import com.library.management.repository.BookRepository;
import com.library.management.repository.UserRepository;

@Service
public class BookIssueServiceImpl implements BookIssueService{
	
	private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
	
	@Autowired
    private BookIssueInfoRepository bookIssueInfoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;
    
 

	@Override
	public BookIssueInfo saveInfo(BookIssueInfo bookIssuedInfo, long userId, long bookId) {
		log.info("adding the book details");
		User user = userRepository.findById(userId).get();
        Books book = bookRepository.findById(bookId).get();
        bookIssuedInfo.setBookId(book);
        bookIssuedInfo.setUserId(user);
        bookIssuedInfo.setIssued_By(user);
        
		return bookIssueInfoRepository.save(bookIssuedInfo);
	}

	@Override
	public List<BookIssueInfo> getAllInformations() {
		log.info("fetching all book informations");
		return bookIssueInfoRepository.findAll();
	}

	@Override
	public Optional<BookIssueInfo> getInfoById(Long id) {
		log.info("fetching all book information by id");
		Optional<BookIssueInfo> bookIssuedInfo=bookIssueInfoRepository.findById(id);
        if(bookIssuedInfo.isPresent())
        {
            return Optional.of(bookIssuedInfo.get());
        }
        else {
            throw new BookIssuedInfoNotFoundException("Transaction not found with id:"+id);
        }
	}

	@Override
	public List<BookIssueInfo> getInfoByStatus(String status) {
		log.info("fetching the status of the book");
		List<BookIssueInfo> bookStatus= bookIssueInfoRepository.findByStatus(status);
        if(bookStatus!=null){
            return bookStatus;
        }else{
            throw new BookIssuedInfoNotFoundException("Transaction not found with status : "+status);
        }
	}

	@Override
	public BookIssueInfo updateBookIssuedInfo(BookIssueInfo bookIssuedInfo) {
		log.info("updating the book information by mentioned id");
		BookIssueInfo transaction = bookIssueInfoRepository.findById(bookIssuedInfo.getTransactionId()).orElseThrow(
                () -> new BookIssuedInfoNotFoundException("Transaction not found with id : " + bookIssuedInfo.getBookId()));
		transaction.setUserId(bookIssuedInfo.getUserId());
		transaction.setBookId(bookIssuedInfo.getBookId());
		transaction.setIssued_By(bookIssuedInfo.getIssued_By());
		transaction.setIssued_To(bookIssuedInfo.getIssued_To());
		transaction.setCreatedOn(bookIssuedInfo.getCreatedOn());
		transaction.setIssueDate(bookIssuedInfo.getIssueDate());
		transaction.setModifiedBy(bookIssuedInfo.getModifiedBy());
		transaction.setReturnDate(bookIssuedInfo.getReturnDate());
		transaction.setStatus(bookIssuedInfo.getStatus());
		transaction.setTransactionId(bookIssuedInfo.getTransactionId());
		return bookIssueInfoRepository.save(transaction);
	}

	@Override
	public void deleteInfo(long id) {
		log.info("delete the book information by id");
		Optional<BookIssueInfo> bookIssuedInfo = this.bookIssueInfoRepository.findById(id);

        if (bookIssuedInfo.isPresent()) {
            this.bookIssueInfoRepository.delete(bookIssuedInfo.get());
        } else {
            throw new BookIssuedInfoNotFoundException("Transaction not found with id : " + id);
        }
	}

}
