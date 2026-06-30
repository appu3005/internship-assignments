package com.sunbeam;

import java.util.ArrayList;
import java.util.List;

public class studentmain {

	public static void main1(String[] args) {
		try(studentDao studDao = new studentDaoimpl()){
			student s = studDao.findById(1); 
			System.out.println(s.toString());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		List<student> list = new ArrayList<>(); 
		try(studentDao studentDao = new studentDaoimpl()){
			list = studentDao.findAll(); 
			for (student s : list) {
				System.out.println(s.toString());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main3(String[] args) {
		try(studentDao studDao = new studentDaoimpl()){
			student s = new student(3, "Pranav", 94); 
			int cnt = studDao.save(s); 
			System.out.println("Rows affected : " +cnt);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}