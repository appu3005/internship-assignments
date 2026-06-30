package com.sunbeam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class studentDaoimpl implements studentDao {
	
	public Connection con;
	public studentDaoimpl() throws Exception{
		con=DButil.getConnection();
	}
	
	@Override
	public void close() throws Exception {
		try {
			con.close();
		}
		catch(Exception e) {
			
		}
	}

	@Override
	public student findById(int roll) throws Exception {
		String sql="select * from student where roll=?";
		try(PreparedStatement stmt= con.prepareStatement(sql))	{
			stmt.setInt(1, roll);
			try(ResultSet rs = stmt.executeQuery()){
				while (rs.next()) {
					int rollNum=rs.getInt("roll");
					String name=rs.getString("name");
					double marks =rs.getDouble("marks");
					student s = new student(rollNum, name, marks);
					return s;
				}
			}
				
			}
	
		return null;
	}

	@Override
	public List<student> findAll() throws Exception {
		List<student> list = new ArrayList<>();
		String sql = "select * from student";
		try(PreparedStatement stmt = con.prepareStatement(sql)){
			try(ResultSet rs = stmt.executeQuery()){
				while(rs.next()) {
					int rollNum = rs.getInt("roll");
					String name=rs.getString("name");
					double marks = rs.getDouble("marks");
					student s = new student(rollNum, name, marks);
					list.add(s);
				}
			}
		}
		return list;
	}

	@Override
	public int save(student s) throws Exception {
			String sql = "INSERT INTO students VALUES(?,?,?)"; 
			try(PreparedStatement stmt = con.prepareStatement(sql)){
				stmt.setInt(1, s.getRoll());
				stmt.setString(2, s.getName());
				stmt.setDouble(3, s.getMarks());
				int cnt = stmt.executeUpdate(); 
				return cnt; 

	}

}
}
