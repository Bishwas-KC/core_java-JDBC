package com.service;

import com.model.Book;

public interface BookService {
	
	void addBook(Book book);
	
	void deleteBook(String isbn);
	
	void updateBook(String isbn, Book book);
	
	void getAllBook();

}
