package com.sunbeam.entity;

public class Student {
	    private int student_id;
	    private String std_name;
	    private String email_id;
	    private  String passward;

		public Student(int student_id, String std_name, String email_id, String passward) {
			super();
			this.student_id = student_id;
			this.std_name = std_name;
			this.email_id = email_id;
			this.passward = passward;
		}


		public Student() {
			// TODO Auto-generated constructor stub
		}


		public int getStudent_id() {
			return student_id;
		}

		public void setStudent_id(int student_id) {
			this.student_id = student_id;
		}

		public String getStd_name() {
		    return std_name;
		
		}

		public void setStd_name(String std_name) {
			this.std_name = std_name;
		}

		public String getEmail_id() {
			return email_id;
		}

		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}

		public String getPassward() {
			return passward;
		}

		public void setPassword(String passward) {
			this.passward = passward;
		}

		@Override
		public String toString() {
			return "Student [student_id=" + student_id + ", std_name=" + std_name + ", email_id=" + email_id
					+ ", password=" + passward + "]";
		}

}




