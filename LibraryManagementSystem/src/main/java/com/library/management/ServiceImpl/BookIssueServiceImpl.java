package com.library.management.ServiceImpl;

import java.util.List;
import java.util.Optional;

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
	
	@Autowired
    private BookIssueInfoRepository bookIssueInfoRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;
    
 

	@Override
	public BookIssueInfo saveInfo(BookIssueInfo bookIssuedInfo, long userId, long bookId) {
		User user = userRepository.findById(userId).get();
        Books book = bookRepository.findById(bookId).get();
        bookIssuedInfo.setBookId(book);
        bookIssuedInfo.setUserId(user);
        bookIssuedInfo.setIssued_By(user);
        
		return bookIssueInfoRepository.save(bookIssuedInfo);
	}

	@Override
	public List<BookIssueInfo> getAllInformations() {
		return bookIssueInfoRepository.findAll();
	}

	@Override
	public Optional<BookIssueInfo> getInfoById(Long id) {
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
		List<BookIssueInfo> bookStatus= bookIssueInfoRepository.findByStatus(status);
        if(bookStatus!=null){
            return bookStatus;
        }else{
            throw new BookIssuedInfoNotFoundException("Transaction not found with status : "+status);
        }
	}

	@Override
	public BookIssueInfo updateBookIssuedInfo(BookIssueInfo bookIssuedInfo) {
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
		Optional<BookIssueInfo> bookIssuedInfo = this.bookIssueInfoRepository.findById(id);

        if (bookIssuedInfo.isPresent()) {
            this.bookIssueInfoRepository.delete(bookIssuedInfo.get());
        } else {
            throw new BookIssuedInfoNotFoundException("Transaction not found with id : " + id);
        }
	}

}
