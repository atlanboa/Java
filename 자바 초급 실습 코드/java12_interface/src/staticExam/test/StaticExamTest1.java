package staticExam.test;
/*
 * static 변수는 생성된 객체들에서 모두 공유한다
 * ::
 * 필드와 static한 변수의 차이점
 */

class Car{
	//Car의 식구 몇명? 한명
	int serialNum;
	static int counter;
	
	Car(){
		counter++;
		serialNum = counter;
	}
}


class StaticExamTest1 {

	
	public static void main(String[] args) {
		Car car1 = new Car();
		Car car2 = new Car();
		Car car3 = new Car();
		
		System.out.println("====non static variable======");
		System.out.println(car1.serialNum);
		System.out.println(car2.serialNum);
		System.out.println(car3.serialNum);
		
		System.out.println("==== static variable======");
		System.out.println(Car.counter);
		System.out.println(car1.counter);
		System.out.println(car2.counter);
		System.out.println(car3.counter);
	}

}
