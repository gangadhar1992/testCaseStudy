package com.example.webProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webProject.model.Book;
import com.example.webProject.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	public BookService bookService;
	
	@GetMapping("/all")
	public List<Book> getAll(){
		return bookService.getAllBooks();
	}
	
	@PostMapping("/addBook")
	public Integer addBook(@RequestBody Book book) throws Exception {
		return bookService.addBook(book);
	}
	
}
