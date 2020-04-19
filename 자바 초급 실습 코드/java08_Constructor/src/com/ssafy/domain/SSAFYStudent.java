package com.ssafy.domain;

import com.ssafy.util.MyDate;

public class SSAFYStudent {
	
	
	
	
	//필드 몇개? 5개
	
	//요런 변수를 뭐라한다? 멤버변수 - 자바진영에선 필드라고 함 필드 서머리, 멤버, 인스턴스라고는 안함
	private String name; //얘네는 클래스 데이터 타입임 앞글자가 대문자인 애들은 모두 초기값이 null임
	private MyDate birthday; //왜 오류? 클래스가 없어서 : MyDate cannot be resolved to a type 이게 클래스 없다는 오류
	
	
	/*
	 * 1. 가지고자 하는 클래스를 필드에 선언
	 * 2. setXxxx(o) 기능을 통해서 필드에 주입한다.
	 */
	
	
	
	private NoteBook notebook;
	//필드선언할 때 잘못된게 있음 이건 스프링할때도 중요함
	//nb보단 notebook이 맞지만 아직 주입은 이뤄지지 않앗음
	
	
    //해당 클래스에서 내가 만든 생성자가 없다면 컴파일러가 기본생성자는 제공한다
	//왜 제공해줌? 아무일도 안하기 때문에 타입만 맞추기 위해 필요한 존재
	//아주 요따만한 일이라도 하면 기본제공 안함
	
	public NoteBook getNotebook() {
		return notebook;
	}

	public void buyNotebook(NoteBook notebook) { //buy의 표현이 더 부드러움
		this.notebook = notebook;
	}
	
//	public void setNotebook(NoteBook notebook) {
//		this.notebook = notebook;
//	}

	private char color; //'\u0000' //한문자가 들어갈 만큼의 공백을 뜻하는 값임 유니코드임
	private int javaScore;
	private int algoScore;
	private int classroom;
	
	//변수에서의 생명은 식별값임 아이덴티파이어!! 딱 보고 어떤 값을 넣는지 확 알아야함 직관성 때문
	//메소드는 하나인데 인자값은 5개 -> 이런거는 반환값이 void임 
	//값은 어디서 받아? 메인에서, 맞는데 테스트클래스 변수에서
	
	
	
	
	
	public void setSSAFYStudent(String name, MyDate birthday, int javaScore, int algoScore, int classroom){ //직관적이지 않음 이렇게 짜면 안됨
			//필드와 로컬변수의 차이는?																	//길어도 똑같이 써주기
			//변수구분의 획? '선언된 위치'가 제일 중요
			//필드는 어디야? 클래스 아래, 즉 메소드 바깥
			//로컬변수는? 메소드 블락 안에
			//2.두번째차이 필드는 '선언만으로' 기본값을 가짐
		//name = name컴터는 모름
				//this는 객체의 주소를 가짐 해당 객체의 레퍼런스를 가짐
		
		this.name = name;
		this.birthday = birthday; //객체가 통째로
		this.javaScore = javaScore;
		
	}
	
	public SSAFYStudent(String name, MyDate birthday, int javaScore, int algoScore,
			int classroom) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.javaScore = javaScore;
		this.algoScore = algoScore;
		this.classroom = classroom;
	}

	//주입된 값을 받아오는 get
	public String/*리턴*/ getSSAFYStudent() {
		//필드의 값을 리턴하고 싶으면? 보통 String으로 함
		return name + "," + birthday;//얜주소값나옴		//네임은왜고대로나옴?						//이걸 집어넣기만 하면 스트링이 무조건 되는지? 하나만 적어줘도 변수 옆에마다 적어줘야되는지
																	//birthday는 클래스 음
				//이렇게 하면 모든 객체들을 클래스로 만들 수 있음 "," 이거????????????
	}
	
	//Has a Relation 누가 누구를 가짐? 싸피 학생이 노트북을 소지하도록 로직을 작성
	//값이 단순 파라미터 값이냐 값이 객체냐 차이일 뿐
	public void setNoteBookInfo(NoteBook notebook) {
		
	}
	
}

//값을 주입하는 것 -> 행위임 -> 메소드지 -> set
//set 이름? setdata 좋은데 도메인이 엄청많자나 -> 구체적으로 써주는 게 좋음

