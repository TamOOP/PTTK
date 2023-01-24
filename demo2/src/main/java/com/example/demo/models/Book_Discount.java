package com.example.demo.models;

public class Book_Discount {
	String maKM;
	String barcode;
	
	public Book_Discount(String maKM, String barcode) {
		this.maKM = maKM;
		this.barcode = barcode;
	}
	public String getMaKM() {
		return maKM;
	}
	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
}
