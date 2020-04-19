package com.ssafy.domain;
//도메인인 이유는 노트북 정보를 저장하는 클래스이기 때문
public class NoteBook {
	/*
	 * 필드에 값이 주입되는 통로는 딱 2가지
	 * 1)setter
	 * 2)명시적 생성자
	 * 잠깐 기본생성자는 필드초기화를 담당한다? no !!!!! yes하면 틀림 기본생성자는 아무것도 안함
	 */
	
	//필드가 3개 -> 필드있네? -> 값을 주입해야함
	//메소드도 있지만 생성자로도 주입할 수 있음
	private String maker;
	public NoteBook(String maker, String brandName, int price) {
		super();
		this.maker = maker;
		this.brandName = brandName;
		this.price = price;
	}

	private String brandName;
	private int price;
	
	public NoteBook() { //worker 지금은 우리가 부르지만se콜링의 주제가 우리임 나중에 ee되면 콜링의 주체가 서버가 됨 그게 제어의 역전임
		//호출안하면? 실행안됨
		//여기에 아무것도 없으면 아무것도 안함 -> 기본생성자임 인자값 없음
		System.out.println("Default.."); //이건 기본생성자입니까? 기본으로봐도됨 아무일도안한다고 봄
	}
	
	public void setNoteBookInfo(String maker, String brandName, int price) {//얘네는 언제 만들어짐? 해당 메소드 호출할 때 worker를 가서 브레이스가 만들어질때 만들어진다는건 메모리 올라가는거임 -> 스택에 올라감
																			//힙은 아님 힙에는 객체식구가 올라감
																			//브레이스가 열릴때 자동으로 생성되고 언제죽어? 필드초기화 일 다하고 24라인 만나면 소멸됨
		  																	//로컬변수는 템포러리 변수라고 보면됨 내가 안죽여도 알아서 소멸됨
		//setNoteBookInfo가 하는일이 뭐에요? 하면 여기 안에를 보면됨
		//하는 일은? 필드 초기화임
		this.maker = maker;
		this.brandName = brandName;
		this.price = price;
	}
	
	public String getNoteBookInfo() {
		return maker + "," + brandName + "," + price;
	}
}
