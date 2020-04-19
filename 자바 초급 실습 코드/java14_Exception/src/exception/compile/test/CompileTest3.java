package exception.compile.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CompileTest3 {

	public static void main(String[] args) {
		String fileName = "src/poem.txt"; //파일 이름임 진짜
		FileReader fr = null;
		try {
			System.out.println("1.fileReader creating");
		fr = new FileReader(fileName);
		
		System.out.println("2.file reading");
		//기능을 씀
		fr.read();
		}catch(FileNotFoundException e) {
			System.out.println("파일을 못찾았습니다");
		}//read();를 위한 또다른 캐치 써줘야함
		catch(IOException e) {
			System.out.println("파일을 읽는데 실패");
		}
		finally {
			try {
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				//System.out.println(); 필요없이 어디서 에러났는지 출력해줌 근데 보안상 문제가 많은 function 요즘은 사용안하는 추세
				System.out.println("자원반납 실패");
			}
		}
	}

}
