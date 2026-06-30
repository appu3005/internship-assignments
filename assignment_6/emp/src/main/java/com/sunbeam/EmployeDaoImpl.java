package com.sunbeam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeDaoImpl implements empDao {
	
	public Connection con;
	public EmployeDaoImpl() throws Exception{
		con=DButil.getConnection();
	}

	@Override
	public void close() throws Exception {
		try {
			con.close();
		} catch (Exception e) {
			
		}
		
	}

	@Override
	public int save(employe e) throws Exception {
		String sql = "insert into emp values (?,?,?,?)";
		try(PreparedStatement stmt=con.prepareStatement(sql)){
			stmt.setInt(1,e.getEmpId());
			stmt.setString(2, e.getEmpname());
			stmt.setString(3, e.getDepartment());
			stmt.setInt(4, e.getSalary());
			int cnt = stmt.executeUpdate();
			return cnt;
		}
	}

	@Override
	public employe UpdateByID(int empId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public employe DeleteByID(int empId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public employe SearchByID(int empId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<employe> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

}
