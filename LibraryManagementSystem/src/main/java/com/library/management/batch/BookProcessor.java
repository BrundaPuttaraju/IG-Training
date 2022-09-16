package com.library.management.batch;

import org.springframework.batch.item.ItemProcessor;

import com.library.management.Entity.Books;

public class BookProcessor implements ItemProcessor<Books,Books> {

	@Override
	public Books process(Books book) throws Exception {
		return book;
	}


}
