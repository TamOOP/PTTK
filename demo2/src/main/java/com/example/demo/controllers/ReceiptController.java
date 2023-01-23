package com.example.demo.controllers;

import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReceiptController {
	@RequestMapping("receipt/list")
	public String receipt_list(Model model) throws SQLException {
		return "receipt/list";
	}
	
	@RequestMapping("receipt/add")
	public String receipt_add(Model model) throws SQLException {
		return "receipt/add";
	}
	
	@RequestMapping("receipt/detail")
	public String receipt_detail(Model model) throws SQLException {
		return "receipt/detail";
	}
}
