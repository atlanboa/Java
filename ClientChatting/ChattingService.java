package gui.client;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/*
 * 채팅 로직...입력받은 TextArea의 내용을 특정한 디렉토리의 파일로 출력하는 로직
 * 저장 버튼을 클릭하면 탐색창 뜨고 특정한 디렉토리에 출력파일을 지정할수 있다.
 * --> FileDialog 클래스 이용!!
 * ::
 * GUI + EventHandler + FileStream
 */
public class ChattingService {	
	//1. gui구성
	Frame f;
	Panel p;
	TextField tf;
	TextArea ta;
	Button save;
	String nickName;
	
	//소켓통신을 위한 필드...
	Socket s;
	BufferedReader br1;
	PrintWriter pw;
	
	//2. gui 생성..
	public ChattingService(String nickName){
		this.nickName = nickName;
		f = new Frame("Chatting Room");
		tf = new TextField(30);
		ta = new TextArea();
		save = new Button("SAVE");
		p = new Panel();
	}	
	
	public void launchFrame() throws Exception{		
		//
		f.setSize(300, 200);
		p.add(tf);
		p.add(save);
		f.add(p, "South");
		f.add(ta, "Center");
		
		ta.setEditable(false);
		f.setResizable(false);
		ta.setText("["+ nickName+"] 님이 들어오셨습니다.");
		f.setVisible(true);
		
		tf.requestFocus();
		
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//소켓통신 로직...
		s = new Socket("127.0.0.1", 60000);
		System.out.println("Client Socket....");
		
		br1 = new BufferedReader(new InputStreamReader(System.in));
		pw = new PrintWriter(s.getOutputStream(), true);
		
		
		//2. 리스너 부착
		tf.addActionListener(new ChattingHandler(this));
		save.addActionListener(new ButtonHandler(this));
		
	}
	
	//추가
	public void threadGo(){
		ClientThread ct = new ClientThread(s,this);
		ct.start();
	}
	public static void main(String[] args)throws Exception {
		ChattingService service = new ChattingService("하바리");
		System.out.println("Client Process Ready.....");
		service.launchFrame();
	}
}

class ClientThread extends Thread{
	Socket s;
	ChattingService service;
	BufferedReader br2;
	String line;
	
	ClientThread(Socket s, ChattingService service){
		this.s = s;
		this.service = service;
	}
	public void run(){
		try{
			br2  =  new BufferedReader(new InputStreamReader(s.getInputStream()));
			while(true){
				line = br2.readLine();		
				//System.out.println(line);
				service.ta.append(line+"\n");
			}
		}catch(IOException e1){
			e1.printStackTrace();
		}
	}
}
























