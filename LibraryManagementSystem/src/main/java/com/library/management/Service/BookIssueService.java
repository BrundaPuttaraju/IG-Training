package com.library.management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.library.management.Entity.BookIssueInfo;

@Service
public interface BookIssueService {

	public BookIssueInfo saveInfo(BookIssueInfo bookIssuedInfo, long userId, long bookId);

    public List<BookIssueInfo> getAllInformations();

    public Optional<BookIssueInfo> getInfoById(Long id);

    public List<BookIssueInfo> getInfoByStatus(String status);

    public BookIssueInfo updateBookIssuedInfo(BookIssueInfo bookIssuedTransaction);

    public void deleteInfo(long id);
	
}
