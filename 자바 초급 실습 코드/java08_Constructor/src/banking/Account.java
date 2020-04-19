package banking;

//Usage


public class Account {
	//객체와
	public int DEFAULT_ACCONT_NO = 1111;
	private double balance;
	private int accountNo; //계좌번호
	
	/*
	 * 오버로딩 :: 생성자  |  메소드
	 * 하는 일은 같지만(이름은 동일하지만)
	 * 처리하는 데이터를 달리할 때 쓰이는 기법 --- 인자값이 순서, 타입, 갯수중 하나라도 달라야한다
	 * 
	 * 
	 * this ::
	 * 1) 필드명과 로컬변수의 이름이 같을 때 구분하기 위해서 필드 앞에 지정
	 * 객체의 레퍼런스값을 가지고 있기 때문에 가능 ... 변수 앞에 쓰이는 this
	 * 2) this() ---- 생성자 앞에 쓰이는 this
	 * 하나의 클래스 내에서 또다른 생성자(생성자 오버로딩!!!!!!!!!!!)
	 * 
	 * 
	 * 생성자 오버로딩은 언제 쓰이니?
	 */
	
	

	public Account(double balance) { //생성자 몇개? 1개임
		//super();
		this.balance = balance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		
	}
	public void withdraw(double amount) {
		if(amount >= 1000) {
			
		}
	}
	
}
