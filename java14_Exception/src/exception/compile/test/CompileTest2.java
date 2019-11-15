package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTest2 {

	public static void main(String[] args) {
		String fileName = "poem.txt"; //파일 이름임 진짜
		FileReader fr = null;
		try {
			System.out.println("1.fileReader creating");
		fr = new FileReader(fileName);
		
		System.out.println("2.file reading");
		//기능을 씀
		fr.read();
		}catch(FileNotFoundException e) {
			System.out.println(e);
		}//read();를 위한 또다른 캐치 써줘야함
		catch(IOException e) {
			System.out.println(e);
		}
		finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
