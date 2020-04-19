package com.ssafy;

public class CarMgr {
	
	public static final int MAX_CAR = 100;
	
	private Car[] cars = new Car[MAX_CAR];
	private int index;
	private int size;
	private int sum;
	
	//1.해당클래스에서 하나의 객체를 무조건 생성
	private static CarMgr carMgr = new CarMgr();
	
	//2.생성자 다른데서 못만들도록 private 붙임
	//여기서 생성자에서 배열을 만들던 처음부터 배열을 만들던 상관없대
	private CarMgr() {
		
	}
	
	//static 붙이는건 이 메소드임
	//3. 만들어놓은 것을 딴데서 쓸 수 있도록 되돌려주는 메소드
	public static CarMgr getInstance() {
		return carMgr;
	}

	//1)파라메터로 전달된 차량 정보를 배열에 저장한다
	public void addCar(Car car) {
		cars[index++] = car;
	}
	
	//2)현재 저장된 모든 차량 정보를 리턴한다
	public Car[] search() {
		return cars;
	}
	
	//3)파라메터로 전달된 번호와 같은 차량 정보를 리턴한다
	public Car search(String num) {
		
		for(Car c : cars) {
			if(c!=null && c.getNum().equals(num)) {
				return c;
			}
		}
		return null;
	}
			
	//4)파라메터로 전달된 가격보다 작은 차량 정보들을 리턴한다
	public Car[] search(int price) {
		Car[] temp = new Car[MAX_CAR];
		for(int i=0; i<cars.length; i++) {
			if(cars[i]!=null && cars[i].getPrice()<price) {
				temp[i] = cars[i];
			}
			
		}
		return temp;
	}
	
	//5)파라메터로 전달된 번호의 차량을 검색하여 가격을 수정한다.
	public void update(String num, int price) {
		
		for(Car c : cars) {
			if(c!=null && c.getNum().equals(num)) {
				c.setPrice(price);
				System.out.println("가격을 수정했습니다.");
			}
		}
		
	}
			
	//6)파라메터로 전달된 번호의 차량을 삭제한다
	public void delete(String num) {
		boolean success = false;
		
		//여기는 향상된 for문 쓰면 안됨 Car c는 임시값이기 때문
		for(int i = 0; i<cars.length; i++) {
			if(cars[i]!=null && cars[i].getNum().equals(num)) {
				cars[i] = null;
				success = true;
				System.out.println(num+"제품을 삭제했습니다.");
			}
		}
		
		if(success) {
			for(int i=0; i<cars.length-1; i++) {
				if(cars[i]==null) {
					cars[i] = cars[i+1];
					cars[i+1] = null;
				}
			}
		}
		
	}
	
	//7)배열에 저장된 차량 대수를 리턴한다.
	public int size() {
		for(Car c : cars) {
			if(c != null) {
				size++;
			}
		}
		return size;
	}
			
	//8)배열에 저장된 차량의 금액 합계를 계산하여 리턴한다.
	public int totalPrice() {
		for(Car c : cars) {
			if(c != null) {
				sum+=c.getPrice();
			}
		}
		return sum;
	}
}
