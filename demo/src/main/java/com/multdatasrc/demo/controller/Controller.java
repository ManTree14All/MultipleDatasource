package com.multdatasrc.demo.controller;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multdatasrc.demo.model.book.Book;
import com.multdatasrc.demo.model.book.repo.BookRepo;
import com.multdatasrc.demo.model.orders.Orders;
import com.multdatasrc.demo.model.orders.repo.OrderRepo;
import com.multdatasrc.demo.model.user.User;
import com.multdatasrc.demo.model.user.repo.UserRepo;

@RestController
@RequestMapping("/source")
class MainController{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private OrderRepo orderRepo;
	
	@PostConstruct
	public void addDBData(){
	userRepo.saveAll(Stream.of(new User(1,"Manish"),new User(2,"Deepak"),new User(3,"Purnima"))
				.collect(Collectors.toList()));
	bookRepo.saveAll(Stream.of(new Book(1,"Java"),new Book(2,"Spring Boot"),new Book(3,"Microservices"))
			.collect(Collectors.toList()));
	orderRepo.saveAll(Stream.of(new Orders(123,"Manish","Spring Boot"),new Orders(124,"Manish","Microservices"),new Orders(234,"Deepak","Java"),new Orders(345,"Purnima","Java"))
			.collect(Collectors.toList()));
	}
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}

	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	@GetMapping("/orders")
	public List<Orders> getAllOrders(){
		return orderRepo.findAll();
	}

}