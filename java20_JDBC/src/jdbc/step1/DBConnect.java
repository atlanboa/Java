package jdbc.step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * 데이터베이스 서버에 연결해서 
 * 쿼리문을 실행하기 위한 준비작업, 그것을 위한
 * 로직을 작성
 * 이걸 jdbc 작업이라 함
 * 1. 서버에 대한 정보를 가지고 있는 Driver를 메모리에 로딩하는게 젤 먼저                                                                                   (url, root, 1234)
 * 2. 디비서버에 연결 -- 연결이 이루어지면 객체가 하나 반환됨 그게 뭐다? Connection 객체를 리턴받는다. getConnection(서버주소, 아이디, 비번) 누가 갖고있음? drivermanager
 * 											Connection conn = DriverManager.getConnection(url, root, 1234);
 * 이걸 호출하게 되면 어떤 일이 벌어지냐먼 이 유저에 해당하는 데이터베이스에 접속이 됨 그리고 Connection이란 객체가 만들어짐 그게 리턴됨
 * 3. PreparedStatement를 하나 생성 === conn.prepareStatement("쿼리문");
 *  PreparedStatement ps = conn.prepareStatement("쿼리문");
 *  여기서 쿼리문 실행되는거 아님 그냥 컴파일할때 들어가는 거임
 * 우리가 jdbc를 만나기전에는 우리가 new로 다 만들어냄
 * 별도의 function을 수행한 결과로 리턴된 것을 받게됨 이제는
 * 기술이 높아질수록 객체생성은 나로부터 멀어짐 나중엔 서버쪽에서 알아서 던져줌 기술이 높아질수록 흐름을 잘 쥐어야함 그래야 안 휘둘리고 부품이 안될꺼임
 * 사람도 component화 되고있음...
 * 4.쿼리문 실행 (디비에 실질적으로 반영됨)
 * 	1)ps.executeUpdate() :: DML 이거하면 조작된 row 수가 리턴됨
 *    int row = ps.executeUpdate();
 * 	2)ps.executeQuery() :: SELECT
 *    ResultSEt rs = ps.executeQuery();
 * 
 */
public class DBConnect {

	//생성자 만들자
	public DBConnect() {
		//1.드라이버 로딩
		//Class.forName("드라이버이름") 여기 갖다놓으면 로딩됨 
		//Class.forName("Driver") 이러면 절대 안됨 어떻게 넣어야함? FQCN 으로 풀 네임으로해야함
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("1. Driver Loading....");//이걸 꼭 넣어주기
			
			//2.디비서버 연결
			//처음이자 마지막 한글처리 해주기 ?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8
			//?물음표는 값전달하기위해 붙임
			//저값은 어디에 전달될꺼같아? 서버에 저 주소에 값이 전달됨
			//값전달하는게 물음표뒤에나옴 값 여러개 전달할땐 & 유니코드지원받을래 예스 & 또받겠다.
			//이런 값 전달방식이 콜렉션 api에서 map방식임 키 밸류
			//콜렉션 api에서 값 전달방식은 3개가 있음 뭐임?
			/*
			 * set, list, map ? 인가???
			 */
			String url = "jdbc:mysql://127.0.0.1:3306/scott?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
			String user = "root";
			String password = "1234";
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("2. DB Server Connection Success....");
			
			//3. PreparedStatement 생성 이때 쿼리문이 인자값으로 들어감
			String query = "INSERT INTO member(id, name, address) VALUES(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("3. PreparedStatement Creating....");
			//컴파일할때 쿼리문이 들어가는거지 되는거 아님
			//근데 그래서 그런지 에러를 일부러 내도 에러가 나는지 모름
			//그래서 여기서 비즈니스 로직의 핵이 나오는거임
			//메소드별로 단위테스트 해야함
			//그래서 unit test가 되야함 단위테스트 철저히 해야함 에러잡는데만 한달이 걸림
			
			
			//근데 이거하면 끝나나? 안됨 왜? 물음표에 값을 안넣어줬음 -> ?물음표에 값이 바인딩이 안됨 바인딩하려면 값 주입이야 get할꺼야 set할꺼야 set하겠지
			ps.setString(1, "111");
			ps.setString(2, "효리");
			ps.setString(3, "제주");
			//필드가 없으니 encapsulation 들이대면 안됨 encapsulation 된거임
			
			
			//4.쿼리문 실행
			System.out.println(ps.executeUpdate() + "row insert");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.out.println("1. Driver Loading Fail....");
			/*
			 * 왜 안됨? class path 설정안해줘서
			 * 어디서나 되도록 디폴트 class path로 설정해줘야함
			 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			System.out.println("2. DB Server Connection Fail....");
		}
	}
	public static void main(String[] args) {
		new DBConnect();
		
		
	}

}
