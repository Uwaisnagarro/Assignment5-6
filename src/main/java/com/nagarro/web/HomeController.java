package com.nagarro.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("")
	public String viewManageBooks() {
		return "redirect:/manage-books";
	}
	

}
