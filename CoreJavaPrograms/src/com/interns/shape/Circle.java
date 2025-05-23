package com.interns.shape;

public class Circle extends Shape {

	void draw() {
		System.out.println("Circle Shape");
	}
	
	@Override
	void calculateArea(int height, int radius) {
		double val =  3.14 * radius*2;
		System.out.println("Area of Circle:: "+val);
	}
	
	public static void main(String[] args) {
		Circle circle = new Circle();
		circle.draw();
		circle.calculateArea(4, 7);
	}

}
