package server.chatting;
/*
 * 여러명의 클라이언트와 연결된 서버칙 채팅 로직
 * Process | Thread
 * 
 */

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerProcessStructure {

	//필드 뽑자
	ServerSocket server;
	Socket s;
	ArrayList<ServerThreadStructure> list;
	
	public ServerProcessStructure() {
		
	}
	
	//잡다한 통신은 다 여기
	public void go() {
		try {
			
		}catch(Exception e){
			
		}
	}
	
	
	
	public static void main(String[] args) {

		//객체생성
		ServerProcessStructure sp = new ServerProcessStructure();
		sp.go();//이러면 go에 있는거 좌라락 수행됨
		
	}//main

}//class


class ServerThreadStructure extends Thread{
	//필드 뽑자
	Socket s;
	BufferedReader br;
	PrintWriter pw;
	ServerProcessStructure sp;
	
	
	
	
	
	public void run() {
		
	}
}
