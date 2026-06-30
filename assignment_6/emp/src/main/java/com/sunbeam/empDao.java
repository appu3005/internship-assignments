package com.sunbeam;

import java.util.List;

public interface empDao extends AutoCloseable {
	int save(employe e) throws Exception;
	employe UpdateByID(int empId) throws Exception;
	employe DeleteByID (int empId) throws Exception;
	employe SearchByID(int empId) throws Exception;
	List<employe> findAll() throws Exception;
	
}
