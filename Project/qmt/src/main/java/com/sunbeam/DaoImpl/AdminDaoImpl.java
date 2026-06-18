package com.sunbeam.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sunbeam.DAO.AdminDao;
import com.sunbeam.DBUtil.DButil;
import com.sunbeam.entity.Admin;

public class AdminDaoImpl implements AdminDao {
	
	public Connection con; 
	public AdminDaoImpl() throws Exception {
	    con = DButil.getConnection();
	}
	
	@Override
	public Admin logAdmin(String email, String password)throws Exception {
		
		String sql = "select * from Admin where email_id =? and password = ?";
		try(PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setString(1, email);
			stmt.setString(2, password);
			
			try(ResultSet rs = stmt.executeQuery()){
					
	
			if (rs.next()) {
			 Admin admin = new Admin();
				admin.setAdmin_id(rs.getInt("admin_id"));
                admin.setAdmin_name(rs.getString("admin_name"));
                admin.setEmail_id(rs.getString("email_id"));
                admin.setPassword(rs.getString("password"));
                return admin;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		return null;
	}
}