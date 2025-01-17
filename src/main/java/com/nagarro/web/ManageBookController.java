package com.nagarro.web;


import com.nagarro.Book;
import com.nagarro.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage-books")
public class ManageBookController {
	
	@Autowired
	private BookServiceImpl service;
	
	@GetMapping
	public String listBooks(Model model) {
		model.addAttribute("books", service.findAll());
		model.addAttribute("newBook", new Book());
		return "booksListing";
	}
	
}
