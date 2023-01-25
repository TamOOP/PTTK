package com.example.demo.models;

import java.sql.SQLException;

import com.example.demo.responsity.BookResponsitory;

public class Book_Receipt {
	String maHD;
	String barcode;
	int amount;
	int pricePay;
	public Book_Receipt(String maHD, String barcode, int amount, int pricePay) {
		this.maHD = maHD;
		this.barcode = barcode;
		this.amount = amount;
		this.pricePay = pricePay;
	}
	public Book getBook() throws SQLException {
		BookResponsitory bImpl = new BookResponsitory();
		Book book = bImpl.getByBarcode(barcode);
		return book;
	}
	public int getDiscount() throws SQLException {
		BookResponsitory bImpl = new BookResponsitory();
		Book book = bImpl.getByBarcode(barcode);
		int discount = book.getPrice() - this.pricePay;
		return discount;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPricePay() {
		return pricePay;
	}
	public void setPricePay(int pricePay) {
		this.pricePay = pricePay;
	}
	
}
