package jdbc.mvc.step3;

import java.io.Serializable;

/*
 * Member 테이블을 인스턴스화 시킨 클래스는?
 * -> 도메인 오브젝트 -- 다른사람은? vo, dto 같은거 붙임
 * 이런 도메인은 어떤 기법으로 적용한다? Encapsulation 기법으로 작성
 */
public class Member implements Serializable {

	private String id;
	private String name;
	private String address;
	
	public Member() {}
	
	public Member(String id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
}
