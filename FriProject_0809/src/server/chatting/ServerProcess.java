package server.chatting;
/*
 * 여러명의 클라이언트와 연결된 서버칙 채팅 로직
 * Process | Thread
 * ::
 * 서버는 클라이언트가 보낸 메세지 받아서
 * 메세지를 보낸 클라이언트를 포함한, 현재 채팅방에 들어온 연결된 모든 클라이언트에게 동일한 메세지를 보낸다 이걸 브로드캐스팅, 전파 라고함 
 * 방송도 브로드캐스팅 방식임 보든 안보든 일단 모든 사람들에게 다 뿌려놓자나 채널 선택은 우리가
 * 
 * 그럼 단톡방에 모든 사람들에게 메세지를 보여주는 건 Process가 해야할까 Thread가 해야할까?
 * 결국 스레드가 저장된 ArrayList를 돌면서 출력해야하니까... 프로세스의 역할인가?
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerProcess {
	public static final int MIDDLE_PORT = 60000;

	//필드 뽑자
	ServerSocket server;
	Socket s;
	ArrayList<ServerThread> list;

	public ServerProcess() {
		//생성자에서 리스트 만들어줌
		list = new ArrayList<>();
	}

	public void broadcast(String str) {

		//리스트를 돌아야함
		for(ServerThread st : list) { //서버스레드 st가 리스트에서 돈다
			//여기서 run을 호출할 순 없자나
			st.send(str);
		}
	}

	public void removeClient(ObjectInputStream ois) {

	}





	//잡다한 통신은 다 여기
	public void go() {
		try {
			server = new ServerSocket(MIDDLE_PORT);
			System.out.println("서버 가동중...");

			while(true) {
				s = server.accept();
				ServerThread st = new ServerThread(s, this);
				System.out.println("서버쓰레드 생성...리스트 추가...");
				list.add(st);
				System.out.println("쓰레드 start...");
				st.start();
			}



		}catch(Exception e){

		}
	}//go


	public static void main(String[] args) {

		//객체생성
		ServerProcess sp = new ServerProcess();
		sp.go();//이러면 go에 있는거 좌라락 수행됨

	}//main

}//class

//여긴 스레드
class ServerThread extends Thread{
	//필드 뽑자
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	ServerProcess sp;
	InetAddress addr;
	String nickName;

	ServerThread(Socket s, ServerProcess sp) {
		this.s = s;
		this.sp = sp;
		addr =s.getInetAddress();
		System.out.println(addr + "님이 서버 접속하셨습니다...");
		try {
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			//문자니까 true꼭해주기
			pw = new PrintWriter(s.getOutputStream(), true); //문자일때, 모았다가 어느정도 차면 한꺼번에 뿌리거든.. 그래서 바로바로 안나옴 그래서 true 한거
		}
		catch(IOException e){

		}
	}

	public void send(String str) {
		pw.println(str);
	}
	
	public void run() {
     //메세지 읽고 뿌리고 하는 기능은 철저하게 run안에서 해야함
		try {
			nickName = br.readLine();
			sp.broadcast("["+nickName+"]"+"님이 입장");//누가 입장했는지 다 떠야하니까
			String str = br.readLine();
			while((str=br.readLine())!=null) {
//			//읽는게 먼저임 br.readline으로 읽어들인걸, 어디로 보내?
//			String message = br.readLine();
//			//여기서 이렇게 하던걸 메소드 하나 더 팜
//			//pw.println(message);
			sp.broadcast(str);
			
		}
		}catch(Exception e) {
			//클라이언트가 접속을 끊으면 소켓 연결이 해지되기 때문에 서버가 여기로 떨어질 것임
			sp.list.remove(this);
			sp.broadcast("["+nickName+"]"+"님이 톼장");
			//콘솔창에도 남겨주기
			System.out.println(addr+" 연결이 끊어졌습니다");
		}
	}
}
