/**

 * 항상 서버를 먼저 가동해야함
 * 클라이언트가 보낸 메세지를 서버가 받아서 
 * 다시 클라이언트 측으로 받은 메세지를 보내는 서버측 로직을 작성
 * 
 *  누가 먼저 메세지를 보내? 무조건 클라이언트 서버가 먼저 보내는 일은 없음
 *  서버는 클라이언트 요청을 받기위해서 무조건 무조건 무조건 서버 소켓을 생성해야함
 *  1. ServerSocket을 생성 '클라이언트 요청이 오기를' 기다리기만 함
 *  	ServerSocket server = new ServerSocket(60000); //1~65535있는데 1~1024는 쓰면 안됨
 *  2. accept()를 통해서 클라이언트와 접속이 이루엊면 Socket을 하나 리턴한다
 *  	Socket s = server.accept();
Listens for a connection to be made to this socket and accepts it.
---------------------------------------------------------------------------
public class Socket
extends Object
implements Closeable
This class implements client sockets (also called just "sockets"). A socket is an endpoint for communication between two machines.

	3.소켓으로부터 입력스트림을 만들어낸다
	BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream());
 */
package socket.server.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author student
 *
 */
public class ServerProcess {

	ServerSocket server;
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	
	//통신을 위한 잡다한 로직
	public void protocol() throws IOException {
		try {
			server = new ServerSocket(60000);
			System.out.println("Server Ready.....");
			
			//s는 클라이언트의 정보를 담고 있음
			s=server.accept(); //여기서 wait for 중임...
			System.out.println(s.getInetAddress() + "님이 접속했음");
			
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(s.getOutputStream(), true);
			
			while(true) {
				String str = br.readLine();
				pw.println(str);
			}
		} finally {
			if(br!=null) br.close();
			if(pw!=null) pw.close();
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException {

		System.out.println("Server Process.....");
		ServerProcess sp = new ServerProcess();
		sp.protocol();
		
		
	/*
	 * 지금 서버가 멀티스레드가 아니라 프로세스 하나여서 딱 한명만 접속됨
	 * 그래서 1대1 통신밖에 안됨
	 * 
	 * 프로세스와 스레드를 철저하게 구분함
	 * 
	 * 스트림을 선언하는곳은 스레드임
	 * 통신하기 때문이래...
	 * 
	 */
		
		
		
		
	}

}
