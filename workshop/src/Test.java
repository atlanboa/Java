
public class Test {

	public static int k1 = 1;
	
	public static void modify(int k) { //int char double ...string
		k+=10;
	}
	public static void modify(String s) { //객체(클래스), 배열,
		s=s+"1";
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String kk="123456";
		//kk= modify(kk);
		System.out.println(kk);
	}

}
