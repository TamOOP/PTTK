package com.example.demo.models;

public class Book {
	String barcode;
	String name;
	String type;
	String NXB;
	int amount;
	String image;
	String author;
	int republish;
	int price;
	String locate;

	public Book(String barcode, String name, String type, String nXB, int amount, String image, String author,
			int republish, int price, String locate) {
		this.barcode = barcode;
		this.name = name;
		this.type = type;
		this.NXB = nXB;
		this.amount = amount;
		this.image = image;
		this.author = author;
		this.republish = republish;
		this.price = price;
		this.locate = locate;
	}
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getRepublish() {
		return republish;
	}

	public void setRepublish(int republish) {
		this.republish = republish;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getLocate() {
		return locate;
	}

	public void setLocate(String locate) {
		this.locate = locate;
	}

	
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
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

