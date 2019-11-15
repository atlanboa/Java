import java.util.*;
public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		BookMgrImpl bm = BookMgrImpl.getInstance();


		Book b1, b2, b3, b4, b5, m1, m2, m3, m4, m5;
		b1 = new Book("001", "책1", 1000, 1);
		b2 = new Book("002", "책2", 2000, 2);
		b3 = new Book("003", "책3", 3000, 3);
		b4 = new Book("004", "책4", 4000, 4);
		b5 = new Book("005", "책5", 5000, 5);
		m1 = new Magazine("006", "잡지1", 1000, 1, 1);
		m2 = new Magazine("007", "잡지2", 2000, 2, 2);
		m3 = new Magazine("008", "잡지3", 3000, 3, 3);
		m4 = new Magazine("009", "잡지4", 4000, 4, 4);
		m5 = new Magazine("010", "잡지5", 5000, 5, 5);

		
		//최초 입력하고 나서는 다시 주석으로 막아주세염...
		bm.add(b1); bm.add(b2); bm.add(b3); bm.add(b4); bm.add(b5);
		bm.add(m1); bm.add(m2); bm.add(m3); bm.add(m4); bm.add(m5);
		 

		while(true) {
			System.out.println("=======================SSAFY 서점========================");
			System.out.println(" 0. 종료");
			System.out.println(" 1. 전체 검색");
			System.out.println(" 2. 금액 합계");
			System.out.println(" 3. 책 판매");
			System.out.println(" 4. 책 구매");
			System.out.println(" 5. 서버로 전송");		
			System.out.println("========================================================");

			int menu = sc.nextInt();
			String isbn="";
			String title="";
			int quantity=0;
			int price=0;

			switch(menu) {
			case 0: bm.close();
			System.out.println("종료합니다.");
			System.exit(0);
			break;
			case 1: bm.intro();bm.searchAll(); break;
			case 2: System.out.println("총 금액 합계는 " + bm.getTotalAmount()+"원 입니다.");break;
			case 3: System.out.println("판매할 isbn, quantity입력");
			isbn = sc.next(); quantity = sc.nextInt();
			try {
				bm.sell(isbn, quantity);
			} catch (QuantityException | ISBNNotFoundException e) {
				e.printStackTrace();
			}
			break;
			case 4:System.out.println("구매할 isbn, quantity입력");
			isbn = sc.next(); quantity = sc.nextInt();
			try {
				bm.buy(isbn, quantity);
			} catch (ISBNNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			case 5:System.out.println("서버로 도서 정보 전송!!");
				bm.send();
			break;
			default:
				break;
			}

			System.out.println("========================================================");
			System.out.println();
		}
	}
}
