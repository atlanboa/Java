package employee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagerImpl implements Manager {
	BufferedReader br;
	BufferedWriter bw;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	FileReader fr;
	FileWriter fw;
	List<Employee> eList  = new ArrayList<>();
	File file;
	
	private static EmployeeManagerImpl emi = new EmployeeManagerImpl();
	/////////////////////////////////////////////////
	//////////      싱글톤으로 변경하세요     ///////////
	///////////////////////////////////////////////
	public static EmployeeManagerImpl getInstance() {
		return emi;
	}
	
	@Override
	public void getFile() {
		// TODO Auto-generated method stub
		
	}
	
	private EmployeeManagerImpl()  {
		file = new File("employee.obj");
		if(file.exists()) {
			try {
				//br = new BufferedReader( new FileReader(file));
				ois = new ObjectInputStream(new FileInputStream(file));
				
				eList = (ArrayList<Employee>)ois.readObject();
	
				ois.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//파일이 존재한다면....
			/*   
			   	파일에 있는 내용을 읽어와서
				Employee를 생성하고 생성된 
				Employee들을 List에 저장한다.
			*/
			
		} else {
			try {

				//file.getParentFile().mkdirs();
				if(file.createNewFile()) {
					System.out.println("파일 생성 성공");
				}
				else
					System.out.println("파일 생성 실패");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//파일이 존재하지 않는다면...파일을 생성부터 한다.			
			
		} 
	}


	
	@Override
	public void saveFile() {
				
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(eList);
			oos.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	/*
	 * 프로그램 종료 시 ArrayList에 저장된 모든 사원에 대한 정보를
	 * 파일에 출력한다.
	 */
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		//예외추가
		return eList.add(employee); 
	}

	@Override
	public boolean deleteEmployee(String eid) {
		////
		for(Employee e : eList) {
			if(e.getEid().equals(eid)) {
				eList.remove(e);
				return true;
			}
		}
		return false;
	}

	@Override
	public Employee findEmployee(String eid) {		
		////
		for(Employee e : eList) {
			if(e.getEid().equals(eid)) {
				return e;
			}
		}
		
		return null;
	}
	@Override
	public void showAll() {
		////
		System.out.println(eList.size());
		for(Employee e : eList) {
			System.out.println(e);
		}


	}

}




