package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

public class Discount {
	String id;
	String name;
	String start;
	String end;
	String method;
	List<bookDiscount> bookDiscounts = new ArrayList<>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public List<bookDiscount> getBookDiscounts() {
		return bookDiscounts;
	}
	public void setBookDiscounts(List<bookDiscount> bookDiscounts) {
		this.bookDiscounts = bookDiscounts;
	}
	
}
