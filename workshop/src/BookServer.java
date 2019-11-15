import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class ServerThread extends Thread{
	//스레드의 필드
	Socket s;
	ObjectInputStream ois;
	BookServer bs;

	public ServerThread(Socket s, BookServer bs) {
		this.s = s;
		this.bs = bs;
		
	}
	
	public void run(){
		try {
			ois = new ObjectInputStream(s.getInputStream());
			
			while(true) {
				ArrayList<Book> b = (ArrayList<Book>)ois.readObject();
				for(Book book : b) {
					System.out.println(book);
				}
			}
		}catch(Exception e) {
			bs.removeThread(this);
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class BookServer{
	ServerSocket ss;
	Socket s;
	ArrayList<ServerThread> list;
	
	public BookServer() {
		list = new ArrayList<>();
	}
	
	public void addThread(ServerThread st) {
		list.add(st);
	}
	
	public void removeThread(ServerThread st) {
		list.remove(st);
	}
	
	public void go() throws Exception{
		ss = new ServerSocket(60000);
		System.out.println("Server Ready.....");
		while(true) {//
			s = ss.accept();
			ServerThread st = new ServerThread(s, this);
			System.out.println(s.getInetAddress()+"님이 접속하셨습니다.");
			
			addThread(st);
			st.start();
		}//while
	}	
	
	public static void main(String[] args) throws Exception {
		BookServer bs = new BookServer();
		bs.go();
	}
}


