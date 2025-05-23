package com.interns.studentmanagementsystem;

public class Student {
	private String sname;
	private int sage;
	private char sgrade;
	private int sid;

	public Student(String sname, int sage, char sgrade, int sid) {
		this.sname = sname;
		this.sage = sage;
		this.sgrade = sgrade;
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getSage() {
		return sage;
	}

	public void setSage(int sage) {
		this.sage = sage;
	}

	public char getSgrade() {
		return sgrade;
	}

	public void setSgrade(char sgrade) {
		this.sgrade = sgrade;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "Student [ID=" + sid + ", Name=" + sname + ", Age=" + sage + ", Grade=" + sgrade + "]";
	}
}
