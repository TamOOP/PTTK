package com.example.demo.responsity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.ConnectDB;
import com.example.demo.models.Book_Receipt;

public class Book_ReceiptRes {
	public List<Book_Receipt> getByReceiptId(String maHD) throws SQLException {
		List<Book_Receipt> brs = null;
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM book_receipt WHERE maHD= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, maHD);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			brs = new ArrayList<>();
			while (rs.next()) {
				brs.add(new Book_Receipt(rs.getString("maHD"),rs.getString("barcode"), rs.getInt("amount"),rs.getInt("pricePay")));
			}
		}
		rs.close();
		ps.close();
		con.close();
		return brs;
	}
}
