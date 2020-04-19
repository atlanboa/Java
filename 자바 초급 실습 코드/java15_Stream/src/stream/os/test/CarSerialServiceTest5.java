package stream.os.test;

import java.util.ArrayList;
public class CarSerialServiceTest5 {

	public static void main(String[] args)throws Exception {
		String path = "list.obj"; //"c:\\kostaObj\\serial\\list.obj";
		//1.Service 객체를 생성
		CarSerialService service = new CarSerialService();
		
		//2. ArrayList객체를 생성
		ArrayList<Car> list = new ArrayList<Car>();
		
		//3. list에 자동차 3대를 생성하고 각각 추가
		list.add(new Car("아우디tfft", 67000000, "white"));
		list.add(new Car("렉스턴", 36000000, "Black"));
		list.add(new Car("소나타", 40000000, "Red"));
		
		//4. service의 직렬화기능을 호출
		service.outputCar(path, list);
		System.out.println("list를 list.obj 파일로 저장했습니다...직렬화!!");
		System.out.println("==========================================\n");
		
		//5. service의 역직렬화기능을 호출...리턴
		ArrayList<Car> returnList=service.inputCar(path);
		for(Car c : returnList){
			//6. 리턴받은 값을 콘솔로 출력
			System.out.println("Model of the Car :: "+c.getModel());
		}		
	}
}








