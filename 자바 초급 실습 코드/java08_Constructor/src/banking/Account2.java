package banking;
/*
 * 통장에 대한 정보를 저장하는 클래스...
 */
//Usage Modifier ::  final, static, abstract, ..
//Access Modifier :: public - protected - private
public class Account2 {
	public static final int  DEFAULT_ACCOUNT_NO = 1111;
	public static final int  DEFAULT_BALANCE = 1000;
	private double balance;
	private int accountNo; //계좌번호
	
	/*
	 * 오버로딩:: 생성자   |   메소드
	 * 하는 일은 같지만--------이름은 동일
	 * 처리하는 데이타를 달리할때 쓰이는 기법--------인자값이 순서, 타입, 갯수중 하나라도 달라야한다
	 * 
	 * this :: 
	 * 
	 * 1)  필드명과 로컬변수의 이름이 같을때 구분하기 위해서 필드앞에 지정
	 *     객체의 레퍼런스값을 가지고 있기 떄문에 가능...변수 앞에 쓰이는  this
	 * 2)  this()   ---- 생성자 앞에 쓰이는  this
	 *     하나의 클래스 내에서 또다른 생성자(생성자 오버로딩)를 호출할때 사용
	 *     
	 * 
	 */
	public Account2(double balance, int accountNo) {
		super();//상속아니자나 누구꺼야? 오브젝트꺼
		//모든 클래스는 오브젝트의 자식이지.
		
		this.balance = balance;
		this.accountNo = accountNo;
	}
//	public Account2(double balance) {		
//		//this.balance = balance; //10000
//		this(balance, DEFAULT_ACCOUNT_NO);
//	}	
	
	
	
	public Account2(double balance) {		
		
		//this(balance, DEFAULT_ACCOUNT_NO); //이 생성자는 반드시 첫라인에 와야한다는거
		super(); //에러왜나지?
		call(balance);
		
		
		
	}
		

//	//에러나는거 보려고 만든거
//	public Account2(double balance) {		
//		call(balance);
//		this.balance = balance; 
//		
//	}
//	
//	
//	
//	
	private void call(double balance2) {
	// TODO Auto-generated method stub
		System.out.println(balance2);

}
//	
	
	
	
	
	public Account2() {	
		this(DEFAULT_BALANCE, DEFAULT_ACCOUNT_NO);		
	}
	
	
	
	public void deposit(double amt) { //4000
		if(amt>=1000) {
			balance += amt; 
		}
	}
	
	public void withdraw(double amt) {
		if(amt<= balance) {
			balance -= amt; 
		}
	}
	public double getBalance() {
		return balance;
	}	
}





