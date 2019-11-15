package com.ssafy;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.DALOAD;

import config.ServerInfo;

public class Test {

	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("1. Driver Loading Success...."); //unit test 완료
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.out.println("1. Driver Loading Fail....");
		}
		
	}
	
	public static void main(String[] args) throws Exception {

		BookDAO dao = BookDAO.getInstance();
//		dao.insertBook(new Book("a1101", "JAVA 기본", "자앤 기술연구소", "자앤 출판사", 23000, "기본"));
//		dao.insertBook(new Book("a1102", "JAVA 중급", "자앤 기술연구소", "자앤 출판사", 25000, "중급"));
//		dao.insertBook(new Book("a1103", "JAVA 실전", "자앤 기술연구소", "자앤 출판사", 30000, "실전"));
	
		//printAllBooks(dao.listBooks());
		
		//System.out.println(dao.findBook("a1101"));
		//dao.insertBook(new Book("a1104", "JAVA 심화", "자앤 기술연구소", "자앤 출판사", 28000, "심화"));
		//dao.updateBook(new Book("a1101", "JAVA 기본", "자앤 기술연구소", "자앤 출판사", 20000, "기본"));
		//dao.deleteBook("a1103");
	}
	
	static void printAllBooks(ArrayList<Book> list) {
		for(Book b : list) {
			System.out.println(b);
		}
	}

}
