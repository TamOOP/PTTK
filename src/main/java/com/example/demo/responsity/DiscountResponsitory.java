package com.example.demo.responsity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.ConnectDB;
import com.example.demo.models.Discount;

public class DiscountResponsitory {
	public List<Discount> getAll() throws SQLException{		
		List<Discount> discounts = null;
		
		return discounts;
	}
	public void insert(Discount discount) throws SQLException {
	}
	public void update(Discount discount) throws SQLException {
	}
	public Discount getById(String id) throws SQLException {
		Discount discount = null;
		
		return discount;
	}
	public List<String> getListType(String maKM) throws SQLException{
		List<String> types = new ArrayList<>();
		
		return types;
		
	}
}
