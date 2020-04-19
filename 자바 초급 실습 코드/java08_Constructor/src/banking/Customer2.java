package banking;

public class Customer2 {
	private String name;
	private int ssn;	
	//
	//의존하기 위해 필드로 받음
	private Account2 account;	
	public Customer2(String name, int ssn) {
		super();
		this.name = name;
		this.ssn = ssn;
	}
	public Account2 getAccount() {
		return account;
	}
	public void setAccount(Account2 account) {
		this.account = account;
	}	
	public String getCustomerInfo() {
		return name+", "+ssn;
	}	
}
