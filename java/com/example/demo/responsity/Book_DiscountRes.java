package com.example.demo.responsity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.ConnectDB;
import com.example.demo.models.Book_Discount;

public class Book_DiscountRes {
	public int insert(Book_Discount bd)throws SQLException {
		Connection con = ConnectDB.getConnection();
		String sql = "INSERT INTO book_discount ( maKM, barcode)"
				+ "VALUES(?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, bd.getMaKM());
		ps.setString(2, bd.getBarcode());
		int result = ps.executeUpdate();
		ps.close();
		con.close();
		return result;
	}
	public List<Book_Discount> getByDiscountId(String id) throws SQLException {
		List<Book_Discount> bds = null;
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM book_discount WHERE maKM= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			bds = new ArrayList<>();
			while (rs.next()) {
				bds.add(new Book_Discount(rs.getString("maKM"),rs.getString("barcode")));
			}
		}
		rs.close();
		ps.close();
		con.close();
		return bds;
	}
	public int deleteByDiscountID(String id) throws SQLException{
		Connection con = ConnectDB.getConnection();
		String sql = "DELETE FROM book_discount WHERE maKM= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		int result = ps.executeUpdate();
		ps.close();
		con.close();
		return result;
	}
	
}
