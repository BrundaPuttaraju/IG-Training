package com.library.management.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.management.Entity.BookIssueInfo;
import com.library.management.Service.BookIssueService;
import com.library.management.exception.BookIssuedInfoNotFoundException;

@RestController
@RequestMapping("/transactions")
public class BookInfoIssueController {

private static final Logger log = LoggerFactory.getLogger(BookInfoIssueController.class);
	 
	@Autowired
	private BookIssueService bookIssueService;

	@PostMapping("/{info}")
	public ResponseEntity<BookIssueInfo> saveTransaction(@RequestBody BookIssueInfo bookIssueInfo,
			@PathVariable("userId") Long userId, @PathVariable("bookId") Long bookId) {
		log.info("adding the book information details");
		return new ResponseEntity<BookIssueInfo>(bookIssueService.saveInfo(bookIssueInfo, userId, bookId),
				HttpStatus.OK);
	}

	@GetMapping("/info")
	public ResponseEntity<List<BookIssueInfo>> getAllInformations() {
		log.info("getting all the book information details");
		List<BookIssueInfo> bookIssued = bookIssueService.getAllInformations();
		return new ResponseEntity<List<BookIssueInfo>>(bookIssued, HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Optional<BookIssueInfo>> getInfoById(@PathVariable("id") long id)
			throws BookIssuedInfoNotFoundException {
		log.info("getting all the book information details by id");
		Optional<BookIssueInfo> byId = bookIssueService.getInfoById(id);
		return new ResponseEntity<Optional<BookIssueInfo>>(byId, HttpStatus.OK);
	}
	
	@GetMapping("/status/{status}")
    public ResponseEntity<List<BookIssueInfo>> getTransactionByStatus(@PathVariable String status) throws BookIssuedInfoNotFoundException {
		log.info("getting status of the book");
		List<BookIssueInfo> byStatus = bookIssueService.getInfoByStatus(status);
        return new ResponseEntity <List<BookIssueInfo>>(byStatus, HttpStatus.OK);
    }
	
	@DeleteMapping("/del/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") long id) throws BookIssuedInfoNotFoundException {
		log.info("deleting the book information details by id");
		bookIssueService.deleteInfo(id);
        return new ResponseEntity<String>("Informations deleted successfully ",HttpStatus.OK);
    }
	

}
