package scream.file.test;
/*
 * 파일에 들어있는 데이터를 읽어서 
 * result.txt 파일로 해당 데이터를 출력하는 로직
 * 
 * 스트림 몇개 필요해? 2개
 * 1. FileReader 기본스트림 | BufferedReader 보조스트림
 * 	  FileWriter        | BufferedWriter
 * 2. 읽어서 while
 * 3. 콘솔로 출력
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileReadingTest4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
//		//1.
//		FileReader fr = new FileReader("poem.txt");
//		BufferedReader br = new BufferedReader(fr);
	
		PrintWriter pw = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		File file = new File("poem.txt");
		try {
		br = new BufferedReader(new FileReader(file));
		pw = new PrintWriter(new FileWriter("result.txt", true), true); //이어쓰기 노드계열만 있음 
																		//이거안하면 덮어쓰기 됨
		//bw = new BufferedWriter(new FileWriter("result.txt"));
	
		String line = null;
		while((line=br.readLine())!=null) {
			//System.out.println(line);
			//bw.write(line+"\n");//이건 한 글자씩임 어케암??? 이 write를 하면
			//bw.newLine();                            요  newline을 해야함
			//bw.flush();
			pw.println(line); //이건 한줄읽고 한줄 씀
			
			//pw.write(line+"\n");
		}
		} finally {
			if(br!=null) br.close(); //자원을 반납함
			/*
			 * 놀이공원 문닫으면 내보내자나 그거랑 같은거임
			 */
			if(pw!=null) pw.close();
		}
		
	}

}
