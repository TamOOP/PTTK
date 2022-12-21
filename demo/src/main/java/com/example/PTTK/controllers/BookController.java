package com.example.PTTK.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.PTTK.models.Book;
import com.example.PTTK.responsity.DAOImpl.*;
@Controller
public class BookController {
	@RequestMapping("/book")
	public String book(Model model) throws SQLException {
		
		return "book";		
	}
	
	@RequestMapping("/booklist")
	public String booklist(Model model) throws SQLException {
		BookResponsitory bImpl = new BookResponsitory();
		List<Book> books = bImpl.getAll();
		model.addAttribute("books" , books);
		return "booklist";
	}
	
}
