//	/**
//		 * 1. Customer 객체를 생성...James
//		 * 2. James가 통장을 하나 개설했음 계좌번호 12345 잔액10000
//		 * 3. James가 개설한 통장을 하나 발급받아서 
//		 * 4. 통장을 지금부터 사용합니다
//		 * 	제일 먼저 5000원 입금
//		 *  500입금 함 -> 안됨
//		 *  8000원입금
//		 *  12000원 출금
//		 *  40000원 출금 - > 안됨
//		 * 5. 최종적으로 James의 통장 잔액을 콘솔로 출력하는 로직을 작성
//		 */
//
//
//package banking.test;
//
//import banking.Customer2;
//import banking.Account2;
//
//public class BankingTest1 {
//
//	public static void main(String[] args) {
//	
//		Customer2 c1 = new Customer2("James", 77);
//		Account2 A2 = new Account2(10000, 12345);
//		c1.setAccount(new Account2(10000, 12345)); //해징관계에서 핵심적인 부분 
//		c1.setAccount(A2); //해징관계에서 핵심적인 부분 
//		
//		Account2 jamesAcc = c1.getAccount();//여기도 중요
//		c1.getAccount().deposit(5000);
//		System.out.println("입금 시작");
//		jamesAcc.deposit(5000);
//		jamesAcc.deposit(500);
//		jamesAcc.deposit(8000); //23000
//		System.out.println("getBalance() :: "+jamesAcc.getBalance()+"원");
//		
//		
//		
//	}
//
//}
