//package exception.user.test;
//
//class User{
//	
//	public void solv(int i, int j) /*throws ArithmeticException*/ {
//		int result = 0;
//		System.out.println("solv() call");
//		/*if(j==0)*/ //ArithmeticException을 여기서 발생시켜라
//			//System.out.println("분모가 " + j+ "라서 나누기를 할 수 없습니다.");
//			//선언안해줘도 됨?
//			//jvm이 하는 일인데 개발자가 명시적으로 발생시켜줄때는 키워드를 하나 더 써야함
//			//throw new ArithmeticException("분모가 0이되면 안됩니다."); //에러 안난다 -> 예외 생성자에는 String Message 받는다.
//			//여기서 예외 발생시켜버리니까 
//		result =  i / j;
//		
//		
//		
//		//연산 i/j 분모가 0이면 안됨
//	
//}
//
//
//
//
//public class UserTest5 {
//
//	public static void main(String[] args) {
//		User user = new User();
//		
//		try {
//		user.solv(10, 0); //폭탄은 호출한 여기서 처리함
//		}catch(ArithmeticException e) {
//			System.out.println(e);
//			user.solv(10,1);
//		}
//		
//	}
//}
