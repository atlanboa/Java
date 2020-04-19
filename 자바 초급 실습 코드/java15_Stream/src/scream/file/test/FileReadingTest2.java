package scream.file.test;
/*
 * 파일에 들어있는 데이터를 읽어서 
 * 콘솔로 출력하는 로직을 작성
 * 
 * 스트림 몇개 필요해? 2개
 * 1. FileReader 기본스트림 | BufferedReader 보조스트림
 * 2. 읽어서 while
 * 3. 콘솔로 출력
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReadingTest2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
//		//1.
//		FileReader fr = new FileReader("poem.txt");
//		BufferedReader br = new BufferedReader(fr);
	
		BufferedReader br = null;
		File file = new File("poem.txt");
		try {
		br = new BufferedReader(new FileReader(file));
		String line = null;
		while((line=br.readLine())!=null) {
			System.out.println(line);
		}
		}finally {
			if(br!=null) br.close();
		}
		
	}

}
