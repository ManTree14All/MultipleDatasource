package com.multdatasrc.demo.model.book.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.multdatasrc.demo.model.book.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
