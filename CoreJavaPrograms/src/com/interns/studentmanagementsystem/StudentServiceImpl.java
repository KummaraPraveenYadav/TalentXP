package com.interns.studentmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements IStudentService {

	private List<Student> students = new ArrayList<>();

	@Override
	public void addStudent(String sname, int sage, char sgrade, int sid) throws StudentDataException {
		if (sage <= 0)
			throw new StudentDataException(" Age must be greater than 0.");
		if (sgrade < 'A' || sgrade > 'F')
			throw new StudentDataException(" Grade must be between A to F only.");

		students.add(new Student(sname, sage, sgrade, sid));
		System.out.println(" Student added successfully........!");
	}

	@Override
	public void removeStudent(int sid) {
		boolean removed = false;

		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getSid() == sid) {
				students.remove(i);
				removed = true;
				System.out.println(" Student with ID " + sid + " removed.");
				break;
			}
		}

		if (!removed) {
			System.out.println(" Student with ID " + sid + " not found.");
		}
	}

	@Override
	public void displayStudents() {
		if (students.isEmpty()) {
			System.out.println(" No students to display.");
		} else {
			System.out.println("\n List of Students:");
			for (Student s : students) {
				System.out.println(s);
			}
		}
	}
}
