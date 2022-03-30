package com.kh.homework.shape.controller;

import com.kh.homework.shape.model.vo.Shape;

public class ShapeController {
	private Shape s = new Shape();	
	
	public double calcPerimeter(int type, double height, double width) {
		s.setType(type);
		s.setHeight(height);
		s.setWidth(width);
		
		return (height + width) * 2;
	}
	
	public double calcArea(int type, double height, double width) {
		s.setType(type);
		s.setHeight(height);
		s.setWidth(width);
		
		if(type == 3) {
			return width * height * 0.5;
		} else {
			return width * height;			
		}
	}
	
	public void paintColor(String color) {
		s.setColor(color);
	}
	
	public String print(int type) {
		if(s.inform() != null) {
			if(type == 3) {
				return "�ﰢ�� / " + s.inform();
			} else {
				return "�簢�� / " + s.inform();
			}
		} else {
			return null;
		}
		
	}
}
