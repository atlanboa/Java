///**
// * 1. 은행 고객을 5명정도 추가
// * 2. 고객의 명수만큼 for문을 돌면서 고객의 정보를 콘솔로 출력하는 로직을 작성
// */
//package banking.test;
//
//import banking.service.BankService;;
//
//public class BankingTest2 {
//
//	public static void main(String[] args) {
//	
//		BankService service = new BankService();
//		
//		service.addCustomer("James1", 1);
//		service.addCustomer("James2", 2);
//		service.addCustomer("James3", 3);
//		service.addCustomer("James4", 4);
//		service.addCustomer("James5", 5);
//		for(int i = 0; i < service.getNumOfCustomers(); i++) {
//			Customer custom = service.getCustomer(i);
//			System.out.println("Customer["+(i+1)+"] is "+custom.getCustomerInfo());
//			
//		}
//		
//	}
//
//}
