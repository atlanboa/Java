
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagerImpl implements Manager {
	BufferedReader br;
	BufferedWriter bw;
	FileReader fr;
	FileWriter fw;
	List<Employee> eList  = new ArrayList<>();
	File file;
	
	/////////////////////////////////////////////////
	//////////      싱글톤으로 변경하세요     ///////////
	///////////////////////////////////////////////
	private static EmployeeManagerImpl mgr = new EmployeeManagerImpl();
	 
	private EmployeeManagerImpl() { 
		file = new File("employee.txt");
		if(file.exists()) {
			//파일이 존재한다면....
			getFile();			
		} else {
			//파일이 존재하지 않는다면...파일을 생성부터 한다.
			try {
				boolean b=file.createNewFile();
				System.out.println("파일 생성 성공..."+b);
			}catch(IOException e) {
				System.out.println("파일 생성 실패...");
			}
		} 
	}
	
	public static EmployeeManagerImpl getInstance() {
		
		return mgr;
	}


	@Override
	public void getFile() {
		try {
			br = new BufferedReader(new FileReader(file));
			String temp=  null;
			
			
			while(true) {
				ArrayList<String> license = new ArrayList<>(); //위치 수정
				
				temp = br.readLine();
				if(temp==null) break;
				String[ ] data =temp.split(",");
				
				Employee emp = new Employee();
				emp.setEid(data[0]);
				
				Employee.serial = Integer.parseInt(data[0]);
				emp.setName(data[1]);
				emp.setSalary(Integer.parseInt(data[2]));
				
				for(int i=3; i<data.length; i++) {
					license.add(data[i]);
				}
				
				emp.setLicense(license); //
				eList.add(emp);	
				
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br!=null) br.close();
			}catch(Exception e) {
				
			}
		}		
	}
	
	@Override
	public void saveFile() {
		try {
			bw = new BufferedWriter(new FileWriter(file));
			for(Employee e : eList){
				bw.write(e+"\n");				
			}
		}catch(Exception e) {
			
		}finally {
			try {
				if(bw!=null) bw.close();
			}catch(Exception e) {
				
			}
		}
	}
	@Override
	public boolean insertEmployee(Employee employee) {
		//예외 추가...
		for(Employee e : eList) {
			if(e.getEid().equals(employee)) {
				
			}
		}
		return eList.add(employee); 
	}

	@Override
	public boolean deleteEmployee(String eid) {
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
		Employee emp=  null;
		for(int i=0; i<eList.size(); i++) {
			if(eList.get(i).getEid().equals(eid)) {
				emp = eList.get(i);
			}				
		}
		return emp;
	}
	
	@Override
	public void showAll() {
		System.out.println(eList.size());
		for(Employee e : eList) {
			System.out.println(e);
		}
	}

}




