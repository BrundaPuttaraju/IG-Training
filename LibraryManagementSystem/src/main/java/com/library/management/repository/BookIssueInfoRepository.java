package com.library.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.management.Entity.BookIssueInfo;

@Repository
public interface BookIssueInfoRepository extends JpaRepository<BookIssueInfo, Long>{

	@Query(value = "select bi from BookIssueInfo bi where bi.userId = id")
    List<BookIssueInfo> findByUserId(Long userId);
	
    @Query(value = "select bi from BookIssueInfo bi where bi.status = status")
    List<BookIssueInfo> findByStatus(String status);
    
}
