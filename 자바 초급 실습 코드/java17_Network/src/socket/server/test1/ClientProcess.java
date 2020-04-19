/**
 * 
 */
package socket.server.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 키보드로 입력받은 데이터를 읽어서 서버로 보낸다
 * --------------------------------
 * 서버가 다시 보낸 메세지를 읽어서
 * 자신의 콘솔창에 메세지를 출력하는 로직을 작성
 * 
 * 1.socket을 생성
 *   Socket s = new Socket("server IP", 60000);
 * 2. 스트림 로직... 
 *
 */
public class ClientProcess {
	Socket s;
	BufferedReader br1, br2;
	PrintWriter pw;
	
	public void protocol() throws IOException{
		try {
			//클라이언트니까 소켓부터 만든다.
			s = new Socket("192.168.32.32", 60000);
			System.out.println("socket creating...");
			
			br1 = new BufferedReader(new InputStreamReader(System.in));
			pw = new PrintWriter(s.getOutputStream(), true);
			
			//서버가 다시 보낸 데이터를 읽는 스트림
			br2 = new BufferedReader(new InputStreamReader(s.getInputStream()));

			while(true) {
				//키보드로 읽은 데이터를
				String str = br1.readLine();
				pw.println(str);
				/////////////////////////////////////////////////
				//서버가 뭔가를 보낼 때 까지 코드가 멈춤
				//서버가 보내온걸 읽음 서버가 뿌린걸 받기 시작하는거임 그게 바로 밑 코드임
				
				//그다음 뭐함?
				//br2.readLine();해서 서버가 보낸거 받음
				String response = br2.readLine();
				System.out.println("Server message : " +response);
			}
			
		}finally {
			//순서대로 해줘야함
			if(br1!=null) br1.close();
			if(pw!=null) pw.close();
			if(br2!=null) br2.close();
		}
	}
	
	public static void main(String[] args) throws IOException{
		ClientProcess cp = new ClientProcess();
		cp.protocol();
	}
}
