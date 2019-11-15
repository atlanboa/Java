import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class BookClient extends Thread{
	public static final int MIDDLE_PORT = 60000;
	ArrayList<Book> list;
	Socket s;
	ObjectOutputStream oos;
	
	public BookClient(ArrayList<Book> list){
		this.list = list;
	}
	public void run() {
		try {
			s = new Socket("127.0.0.1", MIDDLE_PORT);
			System.out.println("Client's Socket Creating...");
			//?
			oos = new ObjectOutputStream(s.getOutputStream());
			//?
			oos.writeObject(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}






