package abcDigital.manage;

import abcDigital.domain.Product;
import abcDigital.domain.Refrigerator;
import abcDigital.domain.TV;

public class ProductMgr {

	public static final int MAX_PRODUCT = 10;

	//private 해야지!!!!!
	private Product[] products = new Product[MAX_PRODUCT];
	private int index;
	private int size;

	//private static 하라고 배웠자낭!!!!
	private static ProductMgr mgr = new ProductMgr();

	//생성자 앞에 private
	private ProductMgr() {}

	//static해야해!!
	public static ProductMgr getInstance() {
		return mgr;
	}

	//상품정보를 객체 배열을 활용하여 저장
	public void addProduct(Product product) {
		//인덱스 쁠쁠!!!
		products[index++] = product;
	}
	//상품정보 전체를 검색하는 기능
	public Product[] getAllProduct() {
		return products;
	}
	//상품번호로 상품을 검색
	public Product searchProductBySerial(String serial) {
		for(Product p : products) {
			if(p!=null&&p.getSerial().equals(serial)) return p;
		}
		System.out.println("해당 상품이 없습니다");
		return null;
	}
	//상품명으로 상품을 검색(부분검색)
	public Product[] searchProductByName(String name) {
		Product[] temp = new Product[index];
		/*for(int i=0; i<temp.length; i++) {
			if(products[i]!=null && products[i].getName().contains(name)) {
				temp[i] = products[i];
			}
		}*/
		for(Product p : products) {
			int count = 0;
			if(p.getName().contains(name)) {
				temp[count++]=p;
			}
		}
		return temp;
	}

	//TV만 검색
	public Product[] searchTV() {
		Product[] temp = new Product[MAX_PRODUCT];
		for(int i=0; i<temp.length; i++) {
			if(products[i]!=null && products[i] instanceof TV) {
				temp[i] = products[i];
			}
		}
		return temp;
	}

	//냉장고만 검색
	public Product[] searchRefrigerator() {
		Product[] temp = new Product[MAX_PRODUCT];
		for(int i=0; i<temp.length; i++) {
			if(products[i]!=null && products[i] instanceof Refrigerator) {
				temp[i] = products[i];
			}
		}
		return temp;
	}

	//상품번호로 상품을 삭제
	public void deleteProductBySerial(String serial) {
		boolean flag = false;
		Product[] temp = new Product[MAX_PRODUCT];
		for(int i=0; i<temp.length; i++) {
			if(products[i]!=null && products[i].getSerial().equals(serial)) {
				products[i] = null;
				flag = true;
				System.out.println(serial+"번 제품이 삭제되었습니다.");
			}
		}

		if(flag) {
			for(int i=0; i<temp.length-1; i++) {
				if(products[i]==null) {
					products[i] = products[i+1];
					products[i+1] = null;

				}
			}
			System.out.println("현재 상품정보 업데이트 완료");
		}

	}

	public int sumAllProducts() {
		int sum = 0;
		for(int i=0; i<products.length; i++) {
			if(products[i]==null) break;
			sum += products[i].getPrice();
		}
		return sum;
	}

	//파라메터로 tv인지 냉장고인지 전달받아 각 제품의 재고금액 리턴
	public int sumByTVorRefrigerator(String type) {
		int sum = 0;

		if(type.equals("TV")) {
			for(Product p : products) {
				if(p!=null && p instanceof TV) {
					sum += p.getPrice();
				}
			}
		}

		else if(type.equals("냉장고")) {
			for(Product p : products) {
				if(p!=null && p instanceof Refrigerator) {
					sum += p.getPrice();
				}
			}
		}




		return sum;
	}

	//전달받아 각 제품의 재고 수량 리턴
	public int amountOfTVorRefrigerator(String type){
		int amount = 0;

		if(type.equals("TV")) {
			for(Product p : products) {
				if(p!=null && p instanceof TV) {
					amount += p.getAmount();
				}
			}
		}

		else if(type.equals("냉장고")) {
			for(Product p : products) {
				if(p!=null && p instanceof Refrigerator) {
					amount += p.getAmount();
				}
			}
		}
		return amount;
	}


	//tv평균인치리턴
	public int avgInchOfTV() {
		int sum=0;
		int cnt=0;
		
		for(Product p : products) {
			if(p!=null && p instanceof TV) {
				sum += ((TV)p).getInch();
				cnt++;
			}
		}
		
		
		return sum/cnt;
	}
	
	//냉장고 리터 합계
	public int sumLiterOfRefrigerator() {
		int sum = 0;
		
		for(Product p : products) {
			if(p!=null && p instanceof Refrigerator) {
				//Q.((Refrigerator)p) vs (Refrigerator)p 무슨 차이??
				sum += ((Refrigerator)p).getLiter();
			}
		}
	
		return sum;
	}
	
	public Product[] searchLowPrice(String name, int price) {
		Product[] temp = new Product[MAX_PRODUCT];
		
		for(int i=0; i<temp.length; i++) {
			if(products[i]!=null && products[i].getName().contains(name) && products[i].getPrice() < price) {
				temp[i] = products[i];
			}
		}
		
		return temp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
