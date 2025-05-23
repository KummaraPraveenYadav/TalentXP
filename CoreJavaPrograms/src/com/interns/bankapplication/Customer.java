package com.interns.bankapplication;

public class Customer {
	private long customerId;
	private String name;
	private String email;
	private String phone;

	public Customer(long customerId, String name, String email, String phone) {
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public long getCustomerId() {
		return customerId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer{" + "ID=" + customerId + ", Name='" + name + '\'' + ", Email='" + email + '\'' + ", Phone='"
				+ phone + '\'' + '}';
	}
}