//package abcDigital.test;
//
//import abcDigital.domain.Product;
//import abcDigital.domain.Refrigerator;
//import abcDigital.domain.TV;
//import abcDigital.manage.ProductMgr;
//
//public class ProductTest {
//
//	//여기서도 배열 크기는 줘야지
//	public static final int MAX = 10;
//
//	public static void main(String[] args) {
//
//		ProductMgr mgr = ProductMgr.getInstance();
//		
//		//ui
//		while(true) {
//			System.out.println();
//			
//			
//			
//			
//			
//			
//			
//			
//		}
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		
//		//기능테스트
//
//		//객체배열을 활용하여 저장
//		mgr.addProduct(new TV("1111", "qled1", 100, 1, 47));
//		mgr.addProduct(new TV("1112", "qled2", 700, 1, 47));
//		mgr.addProduct(new TV("1113", "qled21", 500, 1, 47));
//		mgr.addProduct(new Refrigerator("2111", "삼성", 500, 1, 150));
//		mgr.addProduct(new Refrigerator("2112", "트롬", 570, 1, 200));
//
//		//상품정보 전체 검색
//		for(Product p : mgr.getAllProduct()) {
//			if(p!=null) {
//				System.out.println(p);
//			}
//		}
//		System.out.println("----------------");
//		//상품 번호로 검색
//		//Q.2112 공백이 있는 경우는?
//		System.out.println(mgr.searchProductBySerial("2112"));
//
//		System.out.println("----------------");
//		//상품명으로 검색
//		for(Product p : mgr.searchProductByName("d2")) {
//			if(p!=null) {
//				System.out.println(p);
//			}
//		}
//		System.out.println("----------------");
//		//tv만 검색
//		for(Product p : mgr.searchTV()) {
//			if(p!=null) {
//				System.out.println(p);
//			}
//		}
//		System.out.println("----------------");
//		//냉장고만 검색
//		for(Product p : mgr.searchRefrigerator()) {
//			if(p!=null) {
//				System.out.println(p);
//			}
//		}
//
//		//상품을 삭제
//		mgr.deleteProductBySerial("1111");
//
//		//전체 재고 금액
//		System.out.println(mgr.sumAllProducts());
//
//		System.out.println("---티비니 냉장고니-----");
//
//		//파라메터로 tv인지 냉장고인지 전달받아 각 제품의 재고금액 리턴
//		System.out.println(mgr.sumByTVorRefrigerator("냉장고"));
//
//		//파라메터로 tv인지 냉장고인지 전달받아 각 제품의 재고수량 리턴
//		System.out.println(mgr.amountOfTVorRefrigerator("TV"));
//		
//		System.out.println("---티비니 냉장고니-----");
//		//tv재고 평균 인치
//		System.out.println(mgr.avgInchOfTV());
//		//냉장고 리터 합계
//		System.out.println(mgr.sumLiterOfRefrigerator());
//		
//		System.out.println("---마지막..-----");
//		//파라메터로 상품명과 금액을 전달하면 전달된 상품명을 포함하는 상품 중에서 금액보다 작은 금액의 상품들만 출력
//		for(Product p : mgr.searchLowPrice("d2", 701)) {
//			if(p!=null) {
//				System.out.println(p);
//			}
//		}
//		
//		
//		
//		
//		
//		
//
//	}
//}
