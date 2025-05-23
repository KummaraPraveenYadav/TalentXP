package com.interns.studentmanagementsystem;

import java.util.Scanner;

public class StudentMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IStudentService studentService = new StudentServiceImpl();

		boolean running = true;

		while (running) {
			System.out.println("\n===== Student Management System =====");
			System.out.println("1. Add Student");
			System.out.println("2. Remove Student");
			System.out.println("3. Display Students");
			System.out.println("4. Exit");
			System.out.print("Enter choice: ");

			try {
				int choice = Integer.parseInt(sc.nextLine());

				switch (choice) {
				case 1:
					System.out.print("Enter Name: ");
					String name = sc.nextLine();

					System.out.print("Enter Age: ");
					int age = Integer.parseInt(sc.nextLine());

					System.out.print("Enter Grade (A-F): ");
					char grade = sc.nextLine().toUpperCase().charAt(0);

					System.out.print("Enter Student ID: ");
					int sid = Integer.parseInt(sc.nextLine());

					studentService.addStudent(name, age, grade, sid);
					break;

				case 2:
					System.out.print("Enter Student ID to remove: ");
					int removeId = Integer.parseInt(sc.nextLine());
					studentService.removeStudent(removeId);
					break;

				case 3:
					studentService.displayStudents();
					break;

				case 4:
					System.out.println(" Exiting... Thank you!");
					running = false;
					break;

				default:
					System.out.println(" Invalid choice. Try again.");
				}
			} catch (StudentDataException e) {
				System.out.println(e.getMessage());
			} catch (NumberFormatException e) {
				System.out.println("Please enter valid numeric values.");
			} catch (Exception e) {
				System.out.println(" Something went wrong: " + e.getMessage());
			}
		}

		sc.close();
	}
}
