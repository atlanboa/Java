package broker.domain;
/*
 * 고객에 대한 정보를 보유하고 있는 클래스
 * 필드 어떻게 지정할래? ssn name address 하고 hasing 해야하니까 sharesRec 가져야함니다
 * 그럼 반론 니는 그럼 주식을 한개밖에 못가져
 * -> 어레이리스트안에 제네릭을 shares하면 되겠지
 * 어레이리스트에 이산하 대우증권 800개 이산하 현대증권 500개 이런 식으로 쭉 가짐
 */

import java.util.ArrayList;

public class CustomerRec {
	private String ssn;
	private String name; //컬럼명은 cust_name
	private String address;
	
	private ArrayList<SharesRec> portfolio;

	//생성자 몇개>???? 2개 아니니까 묻겠지 디폴트 하나 더 있는거는 상관 없음
	//3개임 왜? 주식 보유안하고 회원가입만 한 회원이 잇을 수 있자나
	public CustomerRec() {}
	
	//회원가입만 한 고객
	public CustomerRec(String ssn, String name, String address) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}
	//주식까지 보유한 고객
	public CustomerRec(String ssn, String name, String address, ArrayList<SharesRec> portfolio) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
		this.portfolio = portfolio;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<SharesRec> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(ArrayList<SharesRec> portfolio) {
		this.portfolio = portfolio;
	}

	@Override
	public String toString() {
		return "CustomerRec [ssn=" + ssn + ", name=" + name + ", address=" + address + ", portfolio=" + portfolio + "]"+"\n";
	}
	
	
	
	
}
