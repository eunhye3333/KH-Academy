package com.kh.homework.shape.model.vo;

public class Shape {
	private int type;
	private double height;
	private double width;
	private String color = "white";
	
	public Shape() {}
	
	public Shape(int type, double height, double width) {
		this.type = type;
		this.height = height;
		this.width = width;
	}
	
	public String inform() {
		if(height != 0 && width != 0) {
			return "높이 : " + height + " / 너비 : " + width + " / 색깔 : " + color;
		} else {
			return null;
		}
	}
	
	// type
	public void setType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	
	// height
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getHeight() {
		return height;
	}

	// width
	public void setWidth(double width) {
		this.width = width;
	}
	
	public double getWidth() {
		return width;
	}
	
	// color
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	
}
