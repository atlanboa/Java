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
public class FileExamTest1 {

	public static void main(String[] args) {
		 File dir = new File("c:\\filetest\\step1\\code"); //윈도우에서는 디렉토리 구분을 역슬래시 두개로 함
		 File dir2 = new File("c:\\filetest1"); //윈도우에서는 디렉토리 구분을 역슬래시 두개로 함
		 File dir3 = new File("c:\\filetest1\\exam\\data.dat"); //윈도우에서는 디렉토리 구분을 역슬래시 두개로 함
		 //File이란 클래스 객체안에 file생성하는 것과 디렉토리 생성하는 것 있다 안써서 안나오는거
		 System.out.println("파일이 생성디었는지 확인");
		 
		 //디렉토리 만드는 명령어 뭐다?
		 dir2.mkdir(); //탐색기에 진짜 만들어짐!!!!! //폴더 하나만 만들때씀 하위있으면 이거 못씀 
		 dir.mkdirs(); //하위 있을때 근데 없어도 쓸수 있음 
		 /*
		  * 결론 mkdirs 써라 
		  */
		 //dir3.mkdirs();
		 //피씨는 전부 폴더이름이라고 생각함 우리나 .하면 확장자구나 이해하는거지 컴터 바보임
		 /*
		  * 파일이 만들어지려면 디렉토리가 있어야함
		  * 디렉토리 파일은 어케 구분하냐?
		  * 
		  */
		 dir3.getParentFile().mkdirs(); //c:\\filetest1\\exam\\요까지만 긁어옴 파일은 디렉토리 끝에 생성된다는 걸 응용
		 
	}

}
