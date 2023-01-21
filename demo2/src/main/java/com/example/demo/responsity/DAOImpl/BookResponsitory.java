package com.example.demo.responsity.DAOImpl;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.example.demo.ConnectDB;
import com.example.demo.models.Book;
import com.example.demo.responsity.DAO.BookResponsDAO;

public class BookResponsitory implements BookResponsDAO{
	public List<Book> getAll() throws SQLException{
		
		List<Book> books = null;
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM book";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			books = new ArrayList<>();
			while (rs.next()) {
				books.add(new Book(rs.getInt("barcode"), 
						rs.getString("name"), 
						rs.getString("type"),
						rs.getString("nxb"), 
						rs.getInt("amount"),
						rs.getString("image")));
			}
		}
		rs.close();
		ps.close();
		con.close();
		return books;
	}
}
