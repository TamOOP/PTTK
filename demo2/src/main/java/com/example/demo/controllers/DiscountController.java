package com.example.demo.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DiscountController {
	
	@RequestMapping("discount/add")
	public String add(Model model) throws SQLException {
		return "discount/add";
	}
	@RequestMapping("discount/detail")
	public String detail(Model model) throws SQLException {
		return "discount/detail";
	}
	@RequestMapping("discount/edit")
	public String edit(Model model) throws SQLException {
		return "discount/edit";
	}
	@RequestMapping("discount/list")
	public String list(Model model) throws SQLException {
		return "discount/list";
	}
}
