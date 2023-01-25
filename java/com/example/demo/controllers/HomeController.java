package com.example.demo.controllers;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("home/index")
	public String list(Model model) throws SQLException {
		return "home/index";
	}
	
}
