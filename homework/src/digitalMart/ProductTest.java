package digitalMart;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tv tv = new Tv("111", "QLED", 500, 2, "17", "ips");
		Refrigerator rf = new Refrigerator("222", "Trom", 200, 10, 200);
		
		System.out.println(tv.toString());
		System.out.println(rf.toString());
	}

}
