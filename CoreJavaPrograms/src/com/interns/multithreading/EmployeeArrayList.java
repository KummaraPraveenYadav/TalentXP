package com.interns.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeArrayList {

	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<>();

		employees.add(new Employee("111", "Virat", "Kohli", "virat@gmail.com", "Male", "01-01-2004", "good", 10000, 4));
		employees.add(new Employee("222", "Max", "Well", "max@gmail.com", "Male", "01-04-2025", "poor", 15000, 2));
		employees.add(new Employee("333", "Bal", "Krishna", "bal@gmail.com", "Male", "01-04-2025", "avg", 20000, 3));
		employees.add(new Employee("444", "Salman", "Khan", "salam@gmail.com", "Male", "07-02-2000", "poor", 25000, 0));
		employees.add(new Employee("555", "Talent", "XP", "talent@gmail.com", "Male", "06-03-2010", "avg", 30000, 3));
		employees.add(new Employee("666", "Class", "Mate", "class@gmail.com", "Male", "05-04-2004", "good", 40000, 5));

		List<Employee> newJoiners = filterNewJoinersByDate(employees, "01-04-2025");
		System.out.println("Employees who joined on 01-04-2025:");
		newJoiners.forEach(System.out::println);

		System.out.println("\nEmployees whose learning is not 'good':");
		List<Employee> pendingLearning = filterByLearningPending(employees);
		pendingLearning.forEach(System.out::println);
	}

	public static List<Employee> filterNewJoinersByDate(List<Employee> employees, String joinDate) {
		return employees.stream()
				.filter(e -> e.getNewJoiner().equals(joinDate))
				.collect(Collectors.toList());
	}

	public static List<Employee> filterByLearningPending(List<Employee> employees) {
		return employees.stream()
				.filter(e -> !e.getElearningPending().equalsIgnoreCase("good"))
				.collect(Collectors.toList());
	}
}













//package com.interns.multithreading;
//
//import java.util.*;
//import java.util.concurrent.CompletableFuture;
//import java.util.stream.Collectors;
//
//public class EmployeeArrayList {
//
//    public static void main(String[] args) {
//        List<Employee> employees = Arrays.asList(
//            new Employee("111", "Virat", "Kohli", "virat@gmail.com", "Male", "01-01-2004", "good", 10000, 4),
//            new Employee("222", "Max", "Well", "max@gmail.com", "Male", "01-04-2025", "poor", 15000, 2),
//            new Employee("333", "Bal", "Krishna", "bal@gmail.com", "Male", "01-04-2025", "avg", 20000, 3),
//            new Employee("444", "Salman", "Khan", "salam@gmail.com", "Male", "07-02-2000", "poor", 25000, 0),
//            new Employee("555", "Talent", "XP", "talent@gmail.com", "Male", "06-03-2010", "avg", 30000, 3),
//            new Employee("666", "Class", "Mate", "class@gmail.com", "Male", "05-04-2004", "good", 40000, 5)
//        );
//
//        CompletableFuture.supplyAsync(() -> {
//            // Filter New Joiners on a specific date AND Learning is not "good"
//            return employees.stream()
//                .filter(emp -> emp.getNewJoiner().equals("01-04-2025"))
//                .filter(emp -> emp.getElearningPending().equalsIgnoreCase("poor") || emp.getElearningPending().equalsIgnoreCase("avg"))
//                .collect(Collectors.groupingBy(Employee::geteGender));
//        }).thenAcceptAsync(map -> {
//            System.out.println("Filtered New Joiners with Pending Learning grouped by Gender:\n");
//            map.forEach((gender, list) -> {
//                System.out.println("Gender: " + gender);
//                list.forEach(System.out::println);
//                System.out.println();
//            });
//        });
//
//        // Wait for async processing to finish
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
//
