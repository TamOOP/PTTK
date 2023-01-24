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
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM discount";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			discounts = new ArrayList<>();
			while (rs.next()) {
				discounts.add(new Discount(rs.getString("maKM"), 
						rs.getString("name"), 
						rs.getString("start"),
						rs.getString("end"), 
						rs.getString("method"),
						rs.getInt("value"),
						rs.getString("unit")));
			}
		}
		rs.close();
		ps.close();
		con.close();
		return discounts;
	}
	public int insert(Discount discount) throws SQLException {
		Connection con = ConnectDB.getConnection();
		String sql = "INSERT INTO discount ( maKM, name, start , end, method , value, unit)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, discount.getId());
		ps.setString(2, discount.getName());
		ps.setString(3, discount.getStart());
	    ps.setString(4, discount.getEnd());
		ps.setString(5, discount.getMethod());
		ps.setInt(6, discount.getValue());
		ps.setString(7, discount.getUnit());
		int result = ps.executeUpdate();
		ps.close();
		con.close();
		return result;
	}
	public int update(Discount discount) throws SQLException {
		Connection con = ConnectDB.getConnection();
		String sql = "UPDATE discount SET name = ?, start= ?, end= ?, method= ?, value= ?, unit= ? WHERE maKM= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, discount.getName());
		ps.setString(2, discount.getStart());
		ps.setString(3, discount.getEnd());
		ps.setString(4, discount.getMethod());
		ps.setInt(5, discount.getValue());
		ps.setString(6, discount.getUnit());
		ps.setString(7, discount.getId());
		int result = ps.executeUpdate();
		ps.close();
		con.close();
		return result;
	}
	public Discount getById(String id) throws SQLException {
		Discount discount = null;
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM discount WHERE maKM= ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			discount = new Discount(rs.getString("maKM"), 
					rs.getString("name"), 
					rs.getString("start"),
					rs.getString("end"), 
					rs.getString("method"),
					rs.getInt("value"),
					rs.getString("unit"));
		}
		rs.close();
		ps.close();
		con.close();
		return discount;
	}
	public List<String> getListType(String maKM) throws SQLException{
		List<String> types = new ArrayList<>();
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM discount_type WHERE maKM = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, maKM);
		ResultSet rs = ps.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				types.add(rs.getString("type"));
			}
		}
		rs.close();
		ps.close();
		con.close();
		return types;
		
	}
}
