package com.example.demo.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Book;
import com.example.demo.models.Book_Discount;
import com.example.demo.models.Discount;
import com.example.demo.responsity.BookResponsitory;
import com.example.demo.responsity.Book_DiscountRes;
import com.example.demo.responsity.DiscountResponsitory;

@Controller
public class DiscountController {
	
	@RequestMapping("discount/delete")
	public String delete() {
		return "/discount/list";
	}
	@RequestMapping("discount/add")
	public String add(Model model) throws SQLException {
		
		return "discount/add";
	}
	@RequestMapping("discount/detail/{id}")
	public String detail(Model model,@PathVariable String id) throws SQLException {
		
		return "discount/detail";
	}
	@RequestMapping("discount/edit/{id}")
	public String edit(Model model,@PathVariable String id) throws SQLException {
		
		return "discount/edit";
	}
	@RequestMapping("discount/list")
	public String list(Model model) throws SQLException {
		
		return "discount/list";
	}
	@RequestMapping("discount/create")
	public String create() throws SQLException {
		
		return "/discount/detail";
	}
	@RequestMapping("discount/save")
	public String save() throws SQLException {
		
		return "/discount/detail";
	}
}
