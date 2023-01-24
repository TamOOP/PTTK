package com.example.demo.responsity;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.example.demo.ConnectDB;
import com.example.demo.models.Book;

public class BookResponsitory{
	public List<Book> getAll() throws SQLException{
		
		List<Book> books = null;
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM book";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			books = new ArrayList<>();
			while (rs.next()) {
				books.add(new Book(rs.getString("barcode"), 
						rs.getString("name"), 
						rs.getString("type"),
						rs.getString("nxb"), 
						rs.getInt("amount"),
						rs.getString("image"),
						rs.getString("author"),
						rs.getInt("republish"),
						rs.getInt("price"),
						rs.getString("locate")));
			}
		}
		rs.close();
		ps.close();
		con.close();
		return books;
	}
	public Book getByBarcode(String barcode) throws SQLException {
		Book book = null;
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM book WHERE barcode= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, barcode);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			book = new Book(rs.getString("barcode"), 
					rs.getString("name"), 
					rs.getString("type"),
					rs.getString("nxb"), 
					rs.getInt("amount"),
					rs.getString("image"),
					rs.getString("author"),
					rs.getInt("republish"),
					rs.getInt("price"),
					rs.getString("locate"));
		}
		rs.close();
		ps.close();
		con.close();
		return book;
		
	}
	public List<Book> getByType(String type) throws SQLException {
		List<Book> books = null;
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM book WHERE type= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, type);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			books = new ArrayList<>();
			while (rs.next()) {
			books.add(new Book(rs.getString("barcode"), 
					rs.getString("name"), 
					rs.getString("type"),
					rs.getString("nxb"), 
					rs.getInt("amount"),
					rs.getString("image"),
					rs.getString("author"),
					rs.getInt("republish"),
					rs.getInt("price"),
					rs.getString("locate")));
			}
		}
		rs.close();
		ps.close();
		con.close();
		return books;
		
	}
	public int getCountType(String type) throws SQLException {
		int count = 0;
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM book WHERE type= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, type);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				count += 1;
			}
		}
		rs.close();
		ps.close();
		con.close();
		return count;
		
	}
	public int update(Book book) throws SQLException {
		Connection con = ConnectDB.getConnection();
		String sql = "UPDATE book SET name = ?, type = ?, nxb = ?, amount = ?, image = ?, author = ?, republish= ?, price = ?, locate = ?"
				+ "WHERE barcode= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, book.getName());
		ps.setString(2, book.getType());
		ps.setString(3, book.getNXB());
        ps.setInt(4, book.getAmount());
		ps.setString(5, book.getImage());
		ps.setString(6, book.getAuthor());
		ps.setInt(7, book.getRepublish());
		ps.setInt(8, book.getPrice());
		ps.setString(9, book.getLocate());
		ps.setString(10, book.getBarcode());
		int result = ps.executeUpdate();
		ps.close();
		con.close();
		return result;
	}
	public int insert(Book book) throws SQLException {
		Connection con = ConnectDB.getConnection();
		String sql = "INSERT INTO book ( name, type, nxb , amount, image , author, republish, price , locate, barcode)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, book.getName());
		ps.setString(2, book.getType());
		ps.setString(3, book.getNXB());
        ps.setInt(4, book.getAmount());
		ps.setString(5, book.getImage());
		ps.setString(6, book.getAuthor());
		ps.setInt(7, book.getRepublish());
		ps.setInt(8, book.getPrice());
		ps.setString(9, book.getLocate());
		ps.setString(10, book.getBarcode());
		int result = ps.executeUpdate();
		ps.close();
		con.close();
		return result;
	}
}
