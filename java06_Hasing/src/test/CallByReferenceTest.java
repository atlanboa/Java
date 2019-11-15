package test;

class Call{
	int value;
	
	Call(int value) {
		this.value = value;
	}
}



public class CallByReferenceTest {

	public static void main(String[] args) {
		Call c1 = new Call(10);
		Call c2 = new Call(20);
		
		System.out.println("호출전:"+"a="+c1.value+"b="+c2.value);
		call(c1,c2); //calling
		System.out.println("호출후:"+"a="+c1.value+"b="+c2.value);

	}
	private static void call(Call x, Call y) { //10, 20
		
		//주소값이 아니라 값을 바꾼거임 힙에있는 value가 바뀜
		int temp = x.value; //temp = 10
		
		x.value = y.value; //x = 20;
		y.value = temp; //y=10;
	
	}// 20 10 바뀌긴함

}
