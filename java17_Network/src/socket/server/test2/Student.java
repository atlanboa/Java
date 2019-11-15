/**
 * 
 */
package socket.server.test2;

import java.io.Serializable;

/**
 * @author student
 *
 */
public class Student implements Serializable {
	private String name;
	private String address;
	private int age;

	//Serializable 직렬화하려면 디폴드 생성자 반드시 만들어줘야함
	public Student() {}
	public Student(String name, String address, int age) {
		this.name = name;
		this.address = address;
		this.age = age;
		
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", address=" + address + ", age=" + age + "]";
	}
	
	
	
}
