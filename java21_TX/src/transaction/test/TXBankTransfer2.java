package transaction.test;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class TXBankTransfer2 {
	public static void main(String[] args)throws Exception{
		Connection conn=  null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		ResultSet rs = null;
		//1.파일의 정보를 읽어들인다.
		try{
		Properties p = new Properties();
		p.load(new FileInputStream("src/config/jdbc.properties")); //파일시스템이기 때문에 src 꼭 붙여줘야함, 파일 시스템에선 src 조차도 경로임 파일일때는 붙여야함
																	//반면에 class 파일은  src 무조건 잡혀져 있음(이게 classpath 시스템) 이땐 src넣으면 안됨
		
		//2. key로 읽어들인 값을 각각의 변수에 할당.
		String driverName = p.getProperty("jdbc.mysql.driver"); //getProperty에 key 넣으면  value가 할당되는거임
		String url = p.getProperty("jdbc.mysql.url");
		String user = p.getProperty("jdbc.mysql.user");
		String pass = p.getProperty("jdbc.mysql.pass");
		String selectQuery = p.getProperty("jdbc.sql.select");
		String decreaseQuery = p.getProperty("jdbc.sql.decreaseUpdate");
		String increaseQuery = p.getProperty("jdbc.sql.increaseUpdate");
		
		//3. 드라이버 로딩
		Class.forName(driverName);
		System.out.println("driver..loading...");
		
		//4. 서버연결
		conn = DriverManager.getConnection(url, user, pass);
		System.out.println("db conn...");//디비가 연결됨
		/*
		 * 5. 지금부터는 계좌이체에 관련된 모든 쿼리를 하나의 단일 transaction으로 묶을 것이다
		 * :: setAutocommit(false)로 바꾸겠따.그리고 commit()/rollbak()을 적절한곳에 입력
		 * selectQuery를 실행하여 현재 rs에 들어있는 데이타들을 일단 전부다 출력
		 */
		
		//트랜잭션 시작
		conn.setAutoCommit(false);
		
		//현재 계좌금액 확인
		ps1=conn.prepareStatement(selectQuery);
		rs=ps1.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("name")+" "+
							   rs.getString("bankname")+" "+
							   rs.getInt("balance")+" 만원");
		}
		
		ps2 = conn.prepareStatement(decreaseQuery);
		ps2.setInt(1, 500000);
		ps2.setString(2,"윤아");
		//쿼리문 실행되려면? 힌트 나와있네 execute
		ps2.executeUpdate();//윤아 계좌에서 50만원 출금됨
	
		//승기의 계좌로 50만원이 입금됨
		ps3 = conn.prepareStatement(increaseQuery);
		ps3.setInt(1, 500000);
		ps3.setString(2,"승기");
		ps3.executeUpdate();//윤아 계좌에서 50만원 출금됨
		
		conn.commit();
		conn.setAutoCommit(true);
		
		
		}catch(SQLException e){
			System.out.println("========= 계좌이체시 오류 발생 ==========");		
			conn.rollback();
		}finally{
			System.out.println("========= 계좌이체후 정보 확인 ==========");
			
			rs=ps1.executeQuery();
			while(rs.next()){
				int balance = rs.getInt("balance");
				if(balance <0) {
					conn.rollback();
				}
				else{
					System.out.println(rs.getString("name")+" "+
								   rs.getString("bankname")+" "+
								   balance +" 만원");
				}
			}
			conn.setAutoCommit(true); //이거먼저하고 닫아야함 닫고나서 커밋하면 안됨
			
			if(rs!=null)rs.close();
			if(ps1!=null)ps1.close();		
			if(ps2!=null)ps1.close();		
			if(ps3!=null)ps1.close();		
			if(conn!=null)conn.close();
		}	
	}
}


