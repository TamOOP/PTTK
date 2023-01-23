package com.example.demo.models;

public class bookDiscount {
	String maKM;
	String barcode;
	int value;
	String unit;
	public bookDiscount(String maKM, String barcode, int value, String unit) {
		this.maKM = maKM;
		this.barcode = barcode;
		this.value = value;
		this.unit = unit;
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
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
}
