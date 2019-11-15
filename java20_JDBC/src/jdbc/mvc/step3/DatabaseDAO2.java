package jdbc.mvc.step3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

/*
 * 디비 접근하는 비지니스 로직만 작성할꺼임
 * 이건 요청차원이 아님
 * 드라이버메니저가 먼저되야함
 * 초기화보다 초기화되야함
 * 즉 생성자보다 더 먼저되야함 그럼 어디다해? static 블록에
 * 메인보다 더 먼저실행해야하니까 test클래스에서 static에 넣어주면 메인보다 먼저되겠지
 * 
 * 
 * 비즈니스 로직은
 * 서버사이드에서 오직 하나만 존재하는 클래스임
 * 클라이언트의 요청이 아무리 많더라도
 * 해당 dao의 메소드가 클라이언트의 요청을 처리하는 단독 루틴이 된다.
 * 그 말은 메소드 마다마다 각각 디비 서버와의 
 * 절대로 Connection을 필드에 선언하면 안됨
 * 
 * 
 * 
 * DAO 소스코드의 흐름을 보면
 * 비지니스로직의 메소드마다 반복되는 부분이 있음
 * 1) 고정적인 반복
 * 		디비 연결해서 Connection 리턴받는거는 똑같
 * 		자원반납하는 close부분도 똑같
 * 2) 가변적인 반복
 * 쿼리문이 달라져서 그렇기 때문에 밖으로 뺄 수 없음
 * 얘는 못뺌
 */
public class DatabaseDAO2 {

	//싱클톤패턴 적용
	private static DatabaseDAO2 dao = new DatabaseDAO2();
	private DatabaseDAO2() {}
	public static DatabaseDAO2 getInstance() {
		return dao;
	}
	
	//비지니스 로직을 정의
	
//	public void addMember(String id, String name, String address) {
//		
//	} 이렇게 하면 안된다고
	
	public void addMember(Member mem) throws SQLException{
		/*
		 * 디비서버 연결 --- connection
		 * PreparedStatement 생성 ... 쿼리문 작성
		 * 바인딩
		 * 쿼리문 수행
		 * 
		 * 먼저 쓸꺼를 선언해놓고 하는게 중요함
		 * resultSet은 선언할 필요가 없자나 적어도 add메소드에서는
		 */
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
		conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("2. DB Server Connection Success....");
		
		String query = "INSERT INTO member(id, name, address) VALUES(?, ?, ?)";
		ps = conn.prepareStatement(query);
		System.out.println("3. PreparedStatement Creating....");
		
		ps.setString(1, mem.getId());
		ps.setString(2, mem.getName());
		ps.setString(3, mem.getAddress());
		
		System.out.println(ps.executeUpdate() + "row insert ok");
		}
		finally {
			/*
			 * try catch 할 필요는 없음
			 * 여기서도 ioexception 던지기 이거 안해줘도 됨
			 * 열었던거는 반대로 닫아야함 ps가 먼저임
			 */
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
			//이거 만들어놓고 테스트 하라고!!!
		}
		/*
		 * 여기까지 하고 문제? closing 안함
		 * 클로징안하면? 디비서버와 연결이 뚝 끊기게됨
		 * 연결을 햇으면 이 메소드가 끝날 때 무조건 닫아야함
		 * 그걸 어디에햇어? finally에
		 * 근데 지금 예외를 던졋네? 그럼 어디 날아가? test에서 해줘야함
		 * 그러나 예외처리말고 finally를 위해 try 넣어줌
		 */
		
		
	}
		public ArrayList<Member> getAllMember() throws SQLException{
			Connection conn = null;
			PreparedStatement ps= null;
			ResultSet rs= null;
			ArrayList<Member> list = new ArrayList<>();
			
			try {
				conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
				System.out.println("2. DB Server Connection Success....");
				
				String query = "SELECT id, name, address FROM member";
				ps = conn.prepareStatement(query);
				
				rs = ps.executeQuery();
				while(rs.next()) {
					list.add(new Member(rs.getString("id"),
										rs.getString("name"),
										rs.getString("address")));
				}
			}finally {
				if(rs!=null) rs.close();
				if(ps != null) ps.close();
				if(conn!=null) conn.close();
			}
			
			return list;
		}//getAllMember
		
		
		public void updateMember(Member mem) throws SQLException{
			//메소드 하나가 완벽한 요청이랬지
			//update는 뭐해요??? 라고 하면 안됨
			//클라이언트의 요청이 다양할 수 있자나 이름 수정할수도 있고 주소 수정할수도 있고
			//그걸 어떻게 구분할래?
			//그게 중요함
			Connection conn = null;
			PreparedStatement ps= null;
			
			try {
				conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
				System.out.println("2. DB Server Connection Success....");
				//업데이트에서 가장 많은 에러남
				//수정안되는 컬럼하나 뭐지? id지 set뒤에는 pk를 제외한 나머지 컬럼 전부 다 와야지
				String query = "Update member set name=? , address=? WHERE id=? ";
				ps = conn.prepareStatement(query);
				
				//물음표는 순서대로 가야함 첫번째 물음표는 name임 두번째는 주소 3번째는  id
				ps.setString(1, mem.getName());
				ps.setString(2, mem.getAddress());
				ps.setString(3, mem.getId());
				
				System.out.println(ps.executeUpdate() + "row update ok");
			}finally {
				if(ps != null) ps.close();
				if(conn!=null) conn.close();
			}
		}
	
}
	

