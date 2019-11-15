package com.ssafy;

import java.util.Arrays;

public class CarTest {

	public static final int MAX = 100;
	
	public static void main(String[] args) {
		
		CarMgr mgr = CarMgr.getInstance();
		
		//1)파라메터로 전달된 차량 정보를 배열에 저장한다
		mgr.addCar(new Car("1111", "소나타", 100));
		mgr.addCar(new Car("1112", "K5", 200));
		mgr.addCar(new Car("1113", "그렌져", 300));
		mgr.addCar(new Car("1114", "벤츠", 500));
		mgr.addCar(new Car("1115", "람보르기니", 700));
		mgr.addCar(new Bus("21", "시내버스", 1000, 45));
		mgr.addCar(new Bus("22", "시외버스", 2000, 55));
		mgr.addCar(new Truck("31", "10톤트럭", 3000, 300));
		mgr.addCar(new Truck("32", "8톤트럭", 2500, 250));
		
		
		//2)현재 저장된 모든 차량 정보를 리턴한다
		for(Car c : mgr.search()) {
			if(c==null) break;
			System.out.println(c);
		}
		
		
		//3)파라메터로 전달된 번호와 같은 차량 정보를 리턴한다
		System.out.println(mgr.search("1111"));
		
		//4)파라메터로 전달된 가격보다 작은 차량 정보들을 리턴한다
		for(Car c : mgr.search(150)) {
			if(c==null) break;
			System.out.print(c);
		}
		
		//5)파라메터로 전달된 번호의 차량을 검색하여 가격을 수정한다.
		mgr.update("1114", 250);

	
		//6)파라메터로 전달된 번호의 차량을 삭제한다
		mgr.delete("1115");

	
		//7)배열에 저장된 차량 대수를 리턴한다.
		System.out.println(mgr.size());
		
		//8)배열에 저장된 차량의 금액 합계를 계산하여 리턴한다.
		System.out.println(mgr.totalPrice());
	}

}
