/**
 * 
 */
package socket.server.test2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author student
 *
 */
public class ClientProcess {
	public static final int MIDDLE_PORT = 60000;
	Socket s;
	ObjectOutputStream oos;
	
	public void protocol() throws Exception {
		s = new Socket("127.0.0.1", MIDDLE_PORT);
		System.out.println("Client's Socket Creating...");
		
		oos = new ObjectOutputStream(s.getOutputStream());
		
		oos.writeObject(new Student("제임스", "뉴욕", 24));
		
	}
	

	
	public static void main(String[] args) throws Exception {
		ClientProcess cp = new ClientProcess();
		cp.protocol();
	}

}
