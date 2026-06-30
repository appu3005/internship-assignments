package com.sunbeam;

import java.util.List;

public interface studentDao extends AutoCloseable{
	student findById(int roll) throws Exception;
	List<student> findAll() throws Exception;
	int save(student s) throws Exception;
	

}
