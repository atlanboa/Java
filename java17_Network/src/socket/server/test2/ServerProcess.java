/**
 * 
 */
package socket.server.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author student
 *
 */
class ServerThread extends Thread{

	//Thread의 필드...
	Socket s;
	//BufferedReader br;
	//이젠 클라이언트가 보내는걸 객체라고 하자
	ObjectInputStream ois;
	//스레드가 프로세스를 가져야하니까 필드에 선언해야지
	ServerProcess sp;
	
	ServerThread(Socket s, ServerProcess sp){
		this.s = s;
		this.sp = sp;
	}




	public void run() {
		
		try {
			ois = new ObjectInputStream(s.getInputStream());
			
			while(true) {
				Student st = (Student)ois.readObject();
				System.out.println(st);
			}
			
		} catch (Exception e) {
			// 스트림을 못하면???? 예외발생
			//통신이 끊어지면 소켓이 빠개지고 
			//소켓만 넣어주면 안됨
			//중요한 부분임
			sp.removeThread(this);
		}
	}
}

public class ServerProcess {

	//프로세스의 필드...
	public static final int MIDDLE_PORT = 60000;
	ServerSocket server;
	Socket s;
	ArrayList<ServerThread> list;

	public ServerProcess() {
		list = new ArrayList<>();

	}

	public void addThread(ServerThread st) {
		list.add(st);
	}

	public void removeThread(ServerThread st) {
		list.remove(st);
	}

	public void protocol() throws Exception{

		//서버소켓 만들자
		server = new ServerSocket(MIDDLE_PORT);
		System.out.println("Server Ready...");

		//그다음 뭐해? 어셉트
		//근데 이제는 그냥 어셉트 하면 안됨 무한 반복해야하고
		while(true) {
			s= server.accept();
			ServerThread st = new ServerThread(s, this);
			//스레드가 소켓을 가져야지만 소통할 수 있제
			System.out.println(s.getInetAddress()+"님이 접속하셨습니다.");
			
			
			addThread(st);;
			//스타트 하기전 addthread 호출해야지
			st.start();

		}//while

	}


	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{

		ServerProcess sp = new ServerProcess();
		sp.protocol();
	}

}
