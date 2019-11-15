package com.ssafy.test;

//import com.ssafy.domain.NoteBook;
//import com.ssafy.domain.SSAFYStudent; 지워야함
//import com.ssafy.util.MyDate;
import com.ssafy.domain.NoteBook;
import com.ssafy.domain.SSAFYStudent;
import com.ssafy.util.MyDate;

public class SSAFYStudentTest2 {

	//어차피 만들어지는거, 만들어질 때 값도 같이 집어넣으면 더 좋지
	//setter, 생성자의 극명한 차이는? 
	//엔진과 블랙박스 차이와 같다
	//자동차가 만들어질 때 같이 만들어져야함 -> 엔진
	//블박은 있어도 되고 없어도됨
	//and then 넣어도 되고 안넣어도 됨 -> setter임
	/*
	 * 라이프사이클 같이하려할 땐 생성자함 엔진고장나면 폐차함 블박고장난다고 폐차안함
	 * setter는 라이프사이클 관계없이 독자적으로 돌아가는거
	 * 현업에서는 setter주입함 그게 더편하기 때문
	 */
	
	public static void main(String[] args) {
		NoteBook nb = new NoteBook("hp","hp Probook", 150);
		SSAFYStudent st = new SSAFYStudent("민정", new MyDate(1994, 8, 10), 80, 80, 2);
		
		NoteBook nb2 = new NoteBook("hp","hp Probook", 150);
		SSAFYStudent st2 = new SSAFYStudent("민정", new MyDate(1994, 8, 10), 80, 80, 2);
		
		st.buyNotebook(nb);
		st2.buyNotebook(nb2);
		
		//민정이노트북 출력
		System.out.println();
	}
}