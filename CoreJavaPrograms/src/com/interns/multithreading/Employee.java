package com.interns.multithreading;

public class Employee {
	private String eId;
	private String eFirstName;
	private String eLastName;
	private String eEMailId;
	private String eGender;
	private String newJoiner;
	private String elearningPending;
	private int eSalary;
	private int eRating;
	
	//Parameterzied Constructor
	

	public Employee(String eId, String eFirstName, String eLastName, String eEMailId, String eGender, String newJoiner,
			String elearningPending, int eSalary, int eRating) {
		super();
		this.eId = eId;
		this.eFirstName = eFirstName;
		this.eLastName = eLastName;
		this.eEMailId = eEMailId;
		this.eGender = eGender;
		this.newJoiner = newJoiner;
		this.elearningPending = elearningPending;
		this.eSalary = eSalary;
		this.eRating = eRating;
	}
	//Getters and Setters
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String geteId() {
		return eId;
	}

	public void seteId(String eId) {
		this.eId = eId;
	}

	public String geteFirstName() {
		return eFirstName;
	}

	public void seteFirstName(String eFirstName) {
		this.eFirstName = eFirstName;
	}

	public String geteLastName() {
		return eLastName;
	}

	public void seteLastName(String eLastName) {
		this.eLastName = eLastName;
	}

	public String geteEMailId() {
		return eEMailId;
	}

	public void seteEMailId(String eEMailId) {
		this.eEMailId = eEMailId;
	}

	public String geteGender() {
		return eGender;
	}

	public void seteGender(String eGender) {
		this.eGender = eGender;
	}

	public String getNewJoiner() {
		return newJoiner;
	}

	public void setNewJoiner(String newJoiner) {
		this.newJoiner = newJoiner;
	}

	public String getElearningPending() {
		return elearningPending;
	}

	public void setElearningPending(String elearningPending) {
		this.elearningPending = elearningPending;
	}

	public int geteSalary() {
		return eSalary;
	}

	public void seteSalary(int eSalary) {
		this.eSalary = eSalary;
	}

	public int geteRating() {
		return eRating;
	}

	public void seteRating(int eRating) {
		this.eRating = eRating;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eFirstName=" + eFirstName + ", eLastName=" + eLastName + ", eEMailId="
				+ eEMailId + ", eGender=" + eGender + ", newJoiner=" + newJoiner + ", elearningPending="
				+ elearningPending + ", eSalary=" + eSalary + ", eRating=" + eRating + "]";
	}
	
	
	

}
