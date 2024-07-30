package com.nagarro.web;


import com.nagarro.Book;
import com.nagarro.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/add")
public class AddController {
	
	@Autowired
	private BookServiceImpl service;
	
	@GetMapping
	public String add(Model model) {
		model.addAttribute("newBook", new Book());
		return "add";
	}
	

	@PostMapping
	public String add(@Validated @ModelAttribute Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("newBook", book);
			return "add";
		}
		service.add(book);
		return "redirect:/manage-books";
	}
}
