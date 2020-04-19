package stream.os.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CarSerialService {
	public void outputCar(String path, ArrayList<Car> list) throws Exception { //직렬화 기능이 돌아가는 메소드
		File f = new File(path);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
		
		oos.writeObject(list);
		
		oos.close();
		
		//이게 outputCar에서 하는 직렬화 전부다임
		
	}
	
	public ArrayList<Car> inputCar(String path) throws Exception{
		ArrayList<Car> list = null; //선언만하고 리턴받아야함
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(path)));

		list = (ArrayList<Car>)ois.readObject();
		
		
		ois.close();
		
		return list;
	}
}
