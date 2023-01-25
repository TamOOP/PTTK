package com.example.demo.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.models.Book_Receipt;
import com.example.demo.models.Receipt;
import com.example.demo.responsity.Book_ReceiptRes;
import com.example.demo.responsity.ReceiptResponsitory;

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
	
	@RequestMapping("receipt/detail/{maHD}")
	public String receipt_detail(@PathVariable String maHD,Model model) throws SQLException {
		return "receipt/detail";
	}
}
