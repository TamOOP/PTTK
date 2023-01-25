package com.example.demo.responsity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.ConnectDB;
import com.example.demo.models.Receipt;

public class ReceiptResponsitory {
	public List<Receipt> getAll() throws SQLException{
		List<Receipt> receipts = null;
		
		return receipts;
	}
	public Receipt getByMaHD(String maHD) throws SQLException {
		Receipt receipt = null;
		
		return receipt;
	}
}
