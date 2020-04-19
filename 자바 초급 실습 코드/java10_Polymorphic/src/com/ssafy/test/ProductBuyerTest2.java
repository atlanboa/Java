package com.ssafy.test;


public class ProductBuyerTest2 {
	public static void main(String[] args) {	
		/*	
		 *      원래는 객체생성 요렇게함
		TV tv = new TV();
		Computer com = new Computer();
		ProductBuyer buyer = new ProductBuyer();*/

		//이제는 요렇게함
		Product tv = new TV();
		Product com = new Computer();
		Product audio1 = new Audio();
		Product audio2 = new Audio();

		tv.setpNumber(111);
		com.setpNumber(222);
		audio1.setpNumber(333);
		audio2.setpNumber(444);

		ProductBuyer buy = new ProductBuyer();

		//상품을 4개 구입하는 로직을 호출...
		//buy.buyProduct(tv);
		//buy.buyProduct(com);
		//buy.buyProduct(audio1);
		//buy.buyProduct(audio2);
		/*	
		buy.summary();

		System.out.println(" 현재 남은 금액은 :: "+buy.money+" 만원 입니다" );
		System.out.println(" 현재 남은 Bonus Point는 :: "+buy.bonusPoint+" 점 입니다" );

		buy.refund(audio2);
		System.out.println(" 현재 남은 금액은 :: "+buy.money+" 만원 입니다" );
		System.out.println(" 현재 남은 Bonus Point는 :: "+buy.bonusPoint+" 점 입니다" );*/

	}
}

//super class...
class Product{
	int price; 
	int bonusPoint;
	int pNumber; //상품을 구별하는 유니크한 값


	//상품이 만들어질떄 가격이 정해짐,그래서 처음부터 넣음 -> 이떄 보너스도 함꼐 정해짐(상품가의 10%)
	Product(int price){
		this.price = price;
		bonusPoint = (int)(price*0.1); 
	}

	public int getpNumber() {
		return pNumber;
	}

	public void setpNumber(int pNumber) {
		this.pNumber = pNumber;
	}		
}
//Sub Class
class TV extends Product{

	TV(){
		super(150); //이렇게하면 따로 가격 넣을 필요 업슴
	}

	public String toString(){
		return "TV";
	}
}

class Computer extends Product{
	Computer(){
		super(100);
	}

	public String toString(){
		return "Computer";
	}
}

class Audio extends Product{
	Audio(){
		super(100);
	}

	public String toString(){
		return "Audio";
	}
}
//Service Class...
class ProductBuyer{
	//상품4개 삿음 즉 배열 만들어야함
	Product[] items = new Product[10]; //구입한 상품들을 관리하는 저장소 만들어놓기까지 해야함

	//배열이므로 철저하게 인덱스로 관리될 것
	int index = 0;
	//돈있어야사지 보유금액 넣는 변수
	int money = 1000;

	int bonusPoint = 0; //왱 0?? 안샀자나 아직

	public void buyProduct(Product p) {
		/*
		 * 
		 */

		if(p.price > this.money) {
			System.out.println("못사여");
			System.exit(0);
		}
		else {

//			for(int i=0; i<items.length; i++) {
//				
//				this.money -= p.price;
//				this.bonusPoint += p.price * 0.1;
//				items[i] = p;
//			}
			
			
			this.money -= p.price;
			this.bonusPoint += p.bonusPoint;
			items[index++] = p;
		


		}
	}
	
	public void summary() {
		/**
		 * for문을 사용해서 구입한 물건의 총합과 물건의 리스트를 출력
		 * 필요한 변수는 로컬로 선언해서 로직을 작성
		 */
		int sum = 0;
		String itemList ="";
		
		
//		for(int i=0; i<items.length; i++) {
//			//여기 조건 줘야함
//			sum += items[i].price;
//			itemList += items[i].toString();//투스트링 생략하면 되자나!!!!
//			
//			
//		}
		
		for(Product pro : items) {
			if(pro==null) continue; //근데 break로 빠져나와도됨 뒤에 더 볼것도 없자나
			sum += pro.price;
			itemList += pro + ","; //투스트링 생략해도 되는거 이용
			
		}
		
		
		
		System.out.print("지금까지 구입한 물건의 총액은" + sum + "원이고 " + itemList + "사셨습니다");
		
	}
	
	/*
	 * 배열에서 객체를 제거 상품가격만큼 보유금액 늘어나고 보너스는 차감됨
	 * 이런건 향상된 포문 쓰기 좀 그럼
	 */
	public void refund(Product p) {
		for(int i=0; i<items.length; i++) {
			if(p.pNumber == items[i].getpNumber()) {//
				//배열에서 제거란 3번째를 지울꺼라면 4번째가 3번째를 덮어쓰고 게속 댕겨서 덮어쓰는 식으로 해야함
				for(int j = i; j<items.length-1; j++) {
					items[j] = items[j+1];
				}
			}
			
			
			
		}
	}
	
	
	
	
}






