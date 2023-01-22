package com.example.demo.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Book;
import com.example.demo.responsity.DAOImpl.*;
@Controller

public class BookController {
	@RequestMapping("/book/add")
	public String book_add(Model model) throws SQLException {
		return "book/add";
	}

	@RequestMapping("/book/booklist")
	public String booklist(Model model) throws SQLException {
		BookResponsitory bImpl = new BookResponsitory();
		List<Book> books = bImpl.getAll();
		model.addAttribute("books" , books);
		return "book/booklist";
	}
	@RequestMapping("/book/book{barcode}")
	public String book(@PathVariable int barcode,Model model) throws SQLException {
		BookResponsitory bImpl = new BookResponsitory();
		model.addAttribute("book" , bImpl.getByBarcode(barcode));
		return "book/book";		
	}
	@RequestMapping("book/edit{barcode}")
	public String book_edit(@PathVariable int barcode,Model model) throws SQLException {
		BookResponsitory bImpl = new BookResponsitory();
		model.addAttribute("book" , bImpl.getByBarcode(barcode));
		return "book/edit";
	}
	@RequestMapping("/book/save")
	public String save(@RequestParam String bookName, @RequestParam int bookBarcode, @RequestParam String bookAuthor, @RequestParam String bookNXB
			, @RequestParam String bookImage, @RequestParam String bookType, @RequestParam int bookRepublish
			,@RequestParam int bookPrice, @RequestParam int bookAmount, @RequestParam String bookLocate) throws SQLException {
        Book book= new Book(bookBarcode,bookName,bookType,bookNXB,bookAmount,bookImage,bookAuthor,bookRepublish,bookPrice,bookLocate);
        BookResponsitory bImpl = new BookResponsitory();
        bImpl.update(book);
        return "redirect:/book/book" + book.getBarcode();
    }
	
}
