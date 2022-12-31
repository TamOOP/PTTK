package com.example.demo.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Book;
import com.example.demo.responsity.DAOImpl.*;
@Controller
public class BookController {
	@RequestMapping("/book")
	public String book(Model model) throws SQLException {
		BookResponsitory bImpl = new BookResponsitory();
		List<Book> books = bImpl.getAll();
		model.addAttribute("books" , books);
		return "book/book";		
	}
	
	@RequestMapping("/booklist")
	public String booklist(Model model) throws SQLException {
		BookResponsitory bImpl = new BookResponsitory();
		List<Book> books = bImpl.getAll();
		model.addAttribute("books" , books);
		return "book/booklist";
	}
	
	@RequestMapping("book/edit")
	public String book_edit(Model model) throws SQLException {
		return "book/edit";
	}
	
	@RequestMapping("book/add")
	public String book_add(Model model) throws SQLException {
		return "book/add";
	}
}
