package config;
/*
 * 설정 정보를 갖고있는 메타데이터를 넣는 곳은 config라고 함 대부분이
 */
public interface ServerInfo {
	/*
	 * public static final이 생략되어있음 그래서 글자가 없으로 누움
	 */
	String DRIVER_NAME ="com.mysql.cj.jdbc.Driver";
	String URL = "jdbc:mysql://127.0.0.1:3306/safeFood?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String USER = "root";
	String PASSWORD = "1234";

}
