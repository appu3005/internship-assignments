package com.sunbeam.DAO;

import java.util.List;

import com.sunbeam.entity.Admin;

public interface AdminDao {
	
	public Admin logAdmin(String email, String password) throws Exception;
	
	List<com.sunbeam.entity.Result> viewResult () throws Exception;
	
}
