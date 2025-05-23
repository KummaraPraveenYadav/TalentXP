package com.interns.shape;

import java.util.Scanner;

public class Cylinder extends Shape {
	void draw() {
		System.out.println("Cylinder Shape");
	}

	void calculateArea(int height, int radius) {
		double val = 2 * 3.14 * radius * (radius + height);
		System.out.println("Area of Cylinder:: "+val);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Radius:");
		int r = sc.nextInt();

		System.out.println("Enter the height:");
		int h = sc.nextInt();

		Shape s = new Cylinder();
		s.draw();
		s.calculateArea(h, r);
		sc.close();
	}

}
