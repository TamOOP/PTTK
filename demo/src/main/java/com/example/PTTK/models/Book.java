package com.example.PTTK.models;

public class Book {
	int barcode;
	String name;
	String type;
	String NXB;
	int amount;
	String image;
	
	
	public Book(int barcode, String name, String type, String nXB, int amount, String image) {
		this.barcode = barcode;
		this.name = name;
		this.type = type;
		NXB = nXB;
		this.amount = amount;
		this.image = image;
	}
	
	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNXB() {
		return NXB;
	}

	public void setNXB(String nXB) {
		NXB = nXB;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}

