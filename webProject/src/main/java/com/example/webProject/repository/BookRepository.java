package com.example.webProject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webProject.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
}
