package banking.service;
/*
 * 고객을 저장하고
 * 관리하는 기능만을 모아놓은 서비스 클래스
 * 끝에 Service 붙이거나 Manage Manager
 */

import banking.Customer;

public class BankService {
	public static final int MAX_CUSTOMER = 10;
	
	//요거 배열 뭐지?
	private Customer[] customers;
	private int numberOfCustomers;
	
	public BankService() {
		//생성자 안에서 반드시 해줘야하는것 
		customers = new Customer[MAX_CUSTOMER];
		numberOfCustomers = 0; //이걸 인덱스로 쓰자	
	}
	
	public void addCustomer(String name, int ssn) {
		//받은 정보로 커스토머 객체를 만듬
		//그 만든 객체를 배열에 넣으면 됨
		customers[numberOfCustomers++] = new Customer(name, ssn);
		
	}
	
	public int getNumOfCustomers() {
		return numberOfCustomers;
	}
	
	public Customer getCustomer(int index) {
		return customers[index];
	}
	
}
