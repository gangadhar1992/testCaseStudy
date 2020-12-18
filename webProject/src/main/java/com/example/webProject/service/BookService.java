package com.example.webProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webProject.model.Book;
import com.example.webProject.repository.BookRepository;

@Service
public class BookService {
	
    @Autowired
	private BookRepository bookRepository;
    
    
    public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
    
    public Integer addBook(Book book) {
    	bookRepository.save(book);
		return book.getId();
	}

	
}
