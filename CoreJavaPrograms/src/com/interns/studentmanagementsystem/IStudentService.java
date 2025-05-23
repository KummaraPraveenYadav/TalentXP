package com.interns.studentmanagementsystem;

public interface IStudentService {
	void addStudent(String name, int age, char grade, int sid) throws StudentDataException;

	void removeStudent(int sid);

	void displayStudents();
}
