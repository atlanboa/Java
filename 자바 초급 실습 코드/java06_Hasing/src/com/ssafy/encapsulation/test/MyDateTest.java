package com.ssafy.encapsulation.test;

import java.util.Scanner;

/*
 * encapsulation에 대해
 * 데이터 즉 필드를 보호하려는 목적 / 필드를 직접적으로 접근하는 것을 막아야한다
 * 
 * 1.private 필드앞에 지정
 * 2.public void setXxxx(o)
 *   public Xxx getXxx()
 *   메소드를 통해서 같은 클래스의 필드에 접근하는 통로를 만든다
 *  3. setXxx(){
 *      첫 라인 즉 필드초기화직전에 제어문을 작성하여 타당한 값만 필드에 할당되도록 해야함
 *      이게 다이렉트로 꽂는것과의 엄청난 차이  
 *  } 
 */
class MyDate{ //여기다간 public 하면안됨
	
	//같은 클래스 내만 접근 가능
	//필드에 다이렉트로 꽂히는 것을 막기위한게 프라이빗
	//메소드로만 값을 꽂도록 해야함
	
	//설명을 위해 남겨둠
//	private int month;
//	private int day;
//	
//	public int getMonth() {
//		return month;
//	}
//	public void setMonth(int month) {
//		
//		
//		//최종목적지에 값이 투입되기전에, 즉 필드 초기화 직전에 제어해야함
//		this.month = month;
//	}
//	public int getDay() {
//		return day;
//	}
//	public void setDay(int day) {
//		this.day = day;
//	}
	
	
	private int month; //여기에 초기화된 0이 나오는거임
	private int day;
	private int range;
	
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		
		if(month>12||month<=0) {
			System.out.println("잘못된 월의 입력입니다.");
			//여기서 못돌아오게 해도됨
			//return; 그래도 0나오네
			System.exit(0);//하면됨
		}
		this.month = month;
	}
	public int getDay() {
		return day;
	}
//	public void setDay(int day) {
//		
//		switch(this.month) {
//		case 2:
//			this.range = 28;
//			break;
//		case :
//			
//		}
//		
//		if(day>range||day<=0) {
//			System.out.println("잘못된 일의 입력입니다.");
//		}
//		
//		//this.day = day;
//		
//		
//	}
	
	
	public void setDay(int day) {
		
		int range1=0; //로컬변수는 메인이든 뭐든 메소드안에 있으면 초기화해줘야함
		switch(month) { //초기화되었기에 this.안해도됨 그게 아니라 파라미터에 먼쓰가 없자나 있으면 무슨 먼쓰인지 this써서 구분해줘야함
		case 2:
			range1 = 28;
			break;
		case 4: //4,6,9 이런거 안됨 break를 걸어야함
		case 6:
		case 9:
		case 11:
			range1 = 30;
			break;
			default:
				range1 = 31;
			
		}
		
		if(day>range1||day<=0) {
			System.out.println("잘못된 일의 입력입니다.");
			System.exit(0);
		}
		this.day = day;
		
		
	}
}


//클래스 여러개 붙일 수 있음
//퍼블릭은 메인메소드를 갖고있는 클래스에만 붙일 수 있음 
public class MyDateTest {

	public static void main(String[] args) {
		//MyDate md = new MyDate();
		
		//잘못된거? 22월 33일 있나
		//서로 다른 클래스에서 접근할 때 굉장히 조심해야함
		
		//지금 직접적으로 서로다른 클래스에 접근하고 있음 어디에 접근? 필드에 접근 invalid한 값을 할당
		//이렇게 하면 안됨 접근못하게 차단해야함 -> 접근의 허용부분을 지정하는게 뭐다? 접근지정자임 그 중 가장 접근의 허용범위가 좁은게 private 
		//다이렉트하면 구제할 방법이 없음 필드에 꽂아넣기 직전에 뭔짓을 해서 valid값 invalid 값 구분해서 최종 목적인 값 꽂는걸 제어해야함
		//md.month = 22;
		//md.day = 33;
		
		//md.setMonth(33); //에러안남 invalid 값인데도 -> 그래도 얘는 다름 제어가능함
		
		/*
		 * 1. Scanner를 이용해서 월, 일에 해당하는 값을 직접받으세요
		 * 2. setMonth(), setDay() 호출 / worker메소드에서 제어문을 잘 작성
		 * 월부터 하는 이유?
		 * 1 3 5 7 8 10 12 는 31일
		 * 2는 28일
		 * 246911 = 30
		 * 3. 오늘은 x월 x일입니다. 정상적으로 출력
		 * 
		 * 예외 33월 1일 --> 잘못된 ~~입니다.
		 * 0월 1일입니다. 이렇게 출력되지 않도록
		 * 할당안되면 초기값 나올 수 있기 때문에 0월이라고 안나오도록 조심
		 * switch 쓰기
		 *
		 */
		
		 MyDate md = new MyDate();
		 Scanner sc = new Scanner(System.in);
		 int month = sc.nextInt();
		 int day = sc.nextInt();
		 
		 md.setMonth(month); //calling
		 md.setDay(day); //calling
		 
//		 if(md.getMonth()==0 || md.getDay()==0) {
//			 System.out.println("잘못된 날짜입니다.");
//			 return; //해줌
//		 }
		 
		 
		 
		 
		 System.out.println("오늘은"+md.getMonth()+ "월"+md.getDay()+ "일 입니다.");
		 
		 //이렇게 하면 0월이 나옴
		

	}

}
