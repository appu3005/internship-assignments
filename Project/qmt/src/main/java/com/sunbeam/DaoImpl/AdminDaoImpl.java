package com.sunbeam.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.sunbeam.DAO.AdminDao;
import com.sunbeam.DBUtil.DButil;
import com.sunbeam.entity.Admin;
import com.sunbeam.entity.Result;

public class AdminDaoImpl implements AdminDao {
	
	public Connection con; 
	public AdminDaoImpl() throws Exception {
	    con = DButil.getConnection();
	}
	
	@Override
	public Admin logAdmin(String email, String password) throws Exception {

	    String sql =
	            "select * from admin where email_id=? and password=?";

	    PreparedStatement stmt =
	            con.prepareStatement(sql);

	    stmt.setString(1, email);
	    stmt.setString(2, password);

	    ResultSet rs = stmt.executeQuery();

	    if(rs.next()) {

	        System.out.println("Admin Found");

	        Admin admin = new Admin();

	        admin.setAdmin_id(rs.getInt("admin_id"));
	        admin.setAdmin_name(rs.getString("admin_name"));
	        admin.setEmail_id(rs.getString("email_id"));
	        admin.setPassword(rs.getString("password"));

	        return admin;
	    }

	    System.out.println("No Record Found");
	    return null;
	}

	@Override
	public List<Result> viewResult() throws Exception {

	    List<Result> list = new java.util.ArrayList<>();

	    String sql = "select * from result";

	    PreparedStatement stmt = con.prepareStatement(sql);

	    ResultSet rs = stmt.executeQuery();

	    while(rs.next()) {

	        int resultId = rs.getInt("result_id");
	        int studentId = rs.getInt("student_id");
	        int quizId = rs.getInt("quize_id");
	        int score = rs.getInt("score");

	        Result r = new Result(
	                resultId,
	                studentId,
	                quizId,
	                score);

	        list.add(r);
	    }

	    return list;
	}
}
