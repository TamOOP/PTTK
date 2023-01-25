package com.example.demo.controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Book;
import com.example.demo.responsity.BookResponsitory;
@Controller

public class BookController {
	public String removeComma(String text) {
		String regex = "(?<=[\\d])(,)(?=[\\d])";
	    Pattern p = Pattern.compile(regex);
	    String str = text;
	    Matcher m = p.matcher(str);
	    str = m.replaceAll("");
	    return str;
	}
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
	public String book(@PathVariable String barcode,Model model) throws SQLException {
		BookResponsitory bImpl = new BookResponsitory();
		model.addAttribute("book" , bImpl.getByBarcode(barcode));
		return "book/book";		
	}
	@RequestMapping("book/edit{barcode}")
	public String book_edit(@PathVariable String barcode,Model model) throws SQLException {
		BookResponsitory bImpl = new BookResponsitory();
		model.addAttribute("book" , bImpl.getByBarcode(barcode));
		return "book/edit";
	}
	@RequestMapping("/book/save")
	public String save(@RequestParam String bookName, @RequestParam String bookBarcode, @RequestParam String bookAuthor, @RequestParam String bookNXB
			, @RequestParam String bookImage, @RequestParam String bookType, @RequestParam int bookRepublish
			,@RequestParam String bookPrice, @RequestParam int bookAmount, @RequestParam String bookLocate) throws SQLException {
		int price = Integer.parseInt(removeComma(bookPrice));
        Book book= new Book(bookBarcode,bookName,bookType,bookNXB,bookAmount,bookImage,bookAuthor,bookRepublish,price,bookLocate);
        BookResponsitory bImpl = new BookResponsitory();
        bImpl.update(book);
        return "redirect:/book/book" + book.getBarcode();
    }
	@RequestMapping("/book/create")
	public String create(@RequestParam String bookName, @RequestParam String bookAuthor, @RequestParam String bookNXB
			, @RequestParam String bookImage, @RequestParam String bookType, @RequestParam int bookRepublish
			,@RequestParam String bookPrice, @RequestParam int bookAmount, @RequestParam String bookLocate) throws SQLException {
		
		BookResponsitory bImpl = new BookResponsitory();
		List<Book> books = bImpl.getAll();
        String barcode = "BOOK"+(books.size() + 1);
        int price = Integer.parseInt(removeComma(bookPrice));
		Book book= new Book(barcode, bookName,bookType,bookNXB,bookAmount,bookImage,bookAuthor,bookRepublish,price,bookLocate);
        bImpl.insert(book);
        return "redirect:/book/book" + book.getBarcode();
    }
}
