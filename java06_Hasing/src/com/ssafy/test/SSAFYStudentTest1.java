package com.ssafy.test;

import com.ssafy.domain.NoteBook;
import com.ssafy.domain.SSAFYStudent;
import com.ssafy.util.MyDate;

public class SSAFYStudentTest1 {

	//메인메소드를 다른말로? 실행메소드라함 -> 실행이 '메인에서부터' 시작함 jvm이 메인메소드를 찾게되고 한줄씩 인터프리팅과정을 거침
	public static void main(String[] args) {
		/*
		 * 누굴 먼저 만들어야함?
		 * 노트북? 싸피 스튜던트?
		 * 1.NoteBook, SSAFTStudent 객체를 생성... 메모리에 올린다.
		 * 2.NoteBook의 값을 주입
		 * 3.SSAFYStudent 값을 주입 ... 김민정
		 * 4.김민정학생이 노트북을 가지도록 로직을 작성
		 * 5.민정이가 가진 노트북의 정보를 콘솔로 출력하는 로직을 작성
		 * 주석대로 순서대로 하셈 의미가 있음
		 * 
		 * 
		 */
		
		NoteBook noteBook = new NoteBook();
		//세미콜론의 역할
		//1.종료 문장의 종료
		//2.메소드나 생성자같은 애들한테는 종료와 동시에 -> 선언된 곳으로 가요 -> 두글자로 줄여서 '호출'이라함 calling 콜링하면 워킹함

		SSAFYStudent ssafyStudent = new SSAFYStudent(); //1번끝
		
		noteBook.setNoteBookInfo("삼성", "삼성500", 500);//노트북 클래스'에 있는' 메소드를 호출 그냥 안감 값 가지고감 -> 인자값도 같이 호출함 인자값의 (순서, 갯수, 타입)이 정확하게 지켜져야함
														//파라미터 선언 순서나 타입같은 거로 장난 많이함
		MyDate md = new MyDate();
		md.setDate(1994, 8, 10);
		
		
		
		ssafyStudent.setSSAFYStudent("김민정", /*객체 덩어리를 던지면 됨*/md, 0, 0, 2); //2,3
		
		ssafyStudent.buyNotebook(noteBook);//4
		
		//학생이 여러명일 경우 이 코드 굉장히 중요함
		//한명일 땐 값 바로 나옴
		
		//이럴때마다 다른 변수로 해줘야함????? 아니 그때그때마다 받아서 지꺼만 출력해주면 되지
		NoteBook your = ssafyStudent.getNotebook();//객체 전체를 받는 거임
		
		System.out.println(ssafyStudent.getSSAFYStudent());
	}

}//실행끝남 누가 죽어? 필드 -> 클래스가 내려올 때 같이 내려옴 식구니까
