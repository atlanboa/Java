package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTest4 {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		String fileName = "src/poem.txt"; //이렇게 하면 안됨 close를 못하자나 무조건 실행해야 하는데 여기서 터지면 close까지 못감
		FileReader fr = null;				//무조건 finally 해주기 근데 finally만 못쓰니까 try써줌, catch는 저 위에서 하니까 필요없음
		
		try {
		System.out.println("1.fileReader creating");
		fr = new FileReader(fileName);
		
		System.out.println("2.file reading");
		fr.read();
		
		}finally {fr.close();}
	}

	//try catch를 매번해주기 번거로우니 저 위에 던지고, finally 필요하면  try씀
}
