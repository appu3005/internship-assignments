package com.sunbeam.DAO;

import com.sunbeam.entity.Admin;

public interface AdminDao {
	
	public Admin logAdmin(String email, String password) throws Exception;
	
	
}
