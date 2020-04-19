package jdbc.step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ServerInfo;
/*
 * step1에서는 디비서버에 대한 정보가 소스코드 상에 하드코딩 되어져 있었다.
 * 보안적인 측면과 재사용성 측면에서 매우 안좋음  지양되어져야하는 부분임
 * 해결책은??
 * 파일
 * 인터페이스 
 * 서버정보를 외부 자원으로(이 모듈말고 다른 모듈을 말함) 모듈화시키자
 * 이 외부 자원은 메타데이타임(메타데이타란? 정보를 가지는 데이터) 대표적으로 서버정보가 있음
 * 이런 애들은 모두 상수값임
 * 
 */
public class DBConnect {

	//생성자 만들자
	public DBConnect() {
		//1.드라이버 로딩
		//Class.forName("드라이버이름") 여기 갖다놓으면 로딩됨 
		//Class.forName("Driver") 이러면 절대 안됨 어떻게 넣어야함? FQCN 으로 풀 네임으로해야함
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
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
			
			Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
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
			ps.setString(1, "222");
			ps.setString(2, "상순");
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
