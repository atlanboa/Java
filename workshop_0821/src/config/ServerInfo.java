package config;

public interface ServerInfo {
	/*
	 * scott 아님 mydb임
	 */
	String DRIVER_NAME ="com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://127.0.0.1:3306/hw?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String USER = "root";
	String PASSWORD = "1234";

}