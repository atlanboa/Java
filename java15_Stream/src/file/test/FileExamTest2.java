package file.test;

import java.io.File;

/*
 * 파일이란???????
 * 보통의 사람들은 파일 이름을 생각함
 * 파일은 파일 이름보다도 디렉토리가 더 중요함
 * 결론 파일은 디렉토리 + 파일명 합친거다
 * 파일 = 디렉토리 + 파일명
 * 
 */
public class FileExamTest2 {

	public static void main(String[] args) throws Exception {
		String dirName = "c:"+File.separator+"Temp2"+File.separator+"mydir";
		File f1 = new File(dirName);
		
		f1.mkdirs();
		//디렉토리여러개면 getparet 그거하면됨
		File f2 = new File(dirName, "filetest.dat");
		if(f2.createNewFile()) {
			System.out.println("파일생성");
		}
		
		System.out.println(f2.getName());
		System.out.println(f2.getPath()); //절대경로
		System.out.println(f2.getParent()); //절대경로
		f2.deleteOnExit(); //종료될때 디렉토리 안에있는 파일을 삭제
	}

}
