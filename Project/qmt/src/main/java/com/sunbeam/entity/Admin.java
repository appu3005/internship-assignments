package com.sunbeam.entity;

public class Admin {
	
	private int admin_id;
	private String admin_name;
	private String email_id;
	private String password;
	
	public Admin() {
		
	}

	public Admin(int admin_id, String admin_name, String email_id, String password) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.email_id = email_id;
		this.password = password;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", admin_name=" + admin_name + ", email_id=" + email_id + ", password="
				+ password + "]";
	}
	
}
