package com.example.demo.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportController {
	@RequestMapping("report/sale")
	public String sale(Model model) throws SQLException {
		return "report/sale";
	}
}
