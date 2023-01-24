package com.example.demo.models;

public class Discount {
	String id;
	String name;
	String start;
	String end;
	String method;
	int value;
	String unit;
	
	public Discount(String id, String name, String start, String end, String method, int value, String unit) {
		this.id = id;
		this.name = name;
		this.start = start;
		this.end = end;
		this.method = method;
		this.value = value;
		this.unit = unit;
	}
	public String getDiscount() {
		String x = value + unit;
		return x;
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
	
}
