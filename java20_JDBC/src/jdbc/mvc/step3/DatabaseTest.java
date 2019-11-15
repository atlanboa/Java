package jdbc.mvc.step3;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class DatabaseTest {

	public static void main(String[] args) throws Exception {

		 DatabaseDAO dao = DatabaseDAO.getInstance();
//		 try {
//			//dao.addMember(new Member("444", "순덕이", "여의도") );
//			ArrayList<Member> returnList = dao.getAllMember();
//			for(Member m : returnList) {
//				System.out.println(m);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			System.out.println("등록 실패");
//		}
		 //dao.updateMember(new Member("333", "나비", "구미"));
		 dao.deleteMember("333");
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("1. Driver Loading....");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.out.println("1. Driver Loading Fail....");
		}
		
	}

}
