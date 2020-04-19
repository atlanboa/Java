package test;

public class CallByValueTest {

	
	public static void main(String[] args) {
		int a = 10;
		int b = 20;

		System.out.println("호출전:"+"a="+a+"b="+b);
		call(a,b); //calling
		
		//여기서 찍은 a, b는 7,8라인에 쟤네임
		//call 안에서만 바뀌고 끝... 왜?
		System.out.println("호출후:"+"a="+a+"b="+b);
	}

	private static void call(int x, int y) { //10, 20
		int temp = x; //temp = 10
		x = y; //x = 20;
		y = temp; //y=10;
		
		//이런문제내놓고 출력결과물음 1. 10 20 2. 20 10 3.에러난다
		
		//왜 똑같이 나오지?
		
	}// 20 10 바뀌긴함

}
