package com.example.demo.models;

public class Receipt {
	String maHD;
	String date;
	int value;
	
	public Receipt(String maHD, String date, int value) {
		this.maHD = maHD;
		this.date = date;
		this.value = value;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
