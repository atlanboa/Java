package abcDigital.manage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import abcDigital.domain.Product;
import abcDigital.domain.Refrigerator;
import abcDigital.domain.TV;

public class ProductMgrImpl implements IProductMgr {
	
	ObjectInputStream ois;
	ObjectOutputStream oos;
	FileReader fr;
	FileWriter fw;
	List<Product> list = new ArrayList<>();
	File file;
	
	public ProductMgrImpl() {
		file = new File("product.dat"); //product란 이름의 dat파일을 만들기 위해서는 
										/*
										 * 이렇게 파일 객체에 넣어줘야함
										 * 그래야 나중에 createFile인가 그거 할 수 있음
										 * 그때 이 이름의, 이 확장자의 파일이 되는거임
										 * 그리고 파일이란건 디렉토리+파일이라고 했자나
										 * 여기는 디렉토리가 필요없이 바로 같은 폴더내에 있어서 그렇지만
										 * 디렉토리 추가하면 원하는 위치 거기에 파일이 만들어질꺼임
										 */
		//생성자에서 로드를 해줘야 굳이 세이브 버튼 누르지 않아도 전체 검색할 때 바로 나오는 거임
		if(file.exists()) {//파일이 이미 있다면
			load();
		}
		else {//파일이 없다면 만들어주는 것 부터 시작해야지
			
			try {
				if(file.createNewFile()) { //리턴이 불리온이라 조건문에 이렇게 넣어서 성공여부 알수있음
					System.out.println("파일생성 성공");
				}else {
					System.out.println("파일생성 실패");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void addProduct(Product p) throws DuplicateException {
		
		for(Product pp : list) {
			if(list!=null && p.getSerial().equals(pp.getSerial())) {
				throw new DuplicateException();
			}
		}
		
		list.add(p);
		
	}

	@Override
	public Product searchProductBySerial(String serial) throws CodeNotFoundException {
		Product tmpProduct = null;
		for(Product p : list) {
			if(p!=null&&p.getSerial().equals(serial)) {
				tmpProduct = p;
			}
		}
		if(tmpProduct == null) {
			throw new CodeNotFoundException();
		}
		return tmpProduct;

	}

	@Override
	public ArrayList<Product> searchRefrigerator400L() throws ProductNotFoundException {
		ArrayList<Product> temp = new ArrayList<Product>();
		for(Product p : list) {
			if(p!=null&& p instanceof Refrigerator&&((Refrigerator)p).getLiter()>=400) {
				temp.add(p);
			}
			
		}
		if(temp == null) throw new ProductNotFoundException();
		return temp;

	}

	@Override
	public ArrayList<Product> searchTV50inch() throws ProductNotFoundException {
		ArrayList<Product> temp = new ArrayList<Product>();
		for(Product p : list) {
			if(p!=null&& p instanceof TV &&((TV)p).getInch()>=50) {
				temp.add(p);
			}
			
		}
		if(temp == null) throw new ProductNotFoundException();
		return temp;
	}

	@Override
	public void save() {
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(list);
			oos.close();
			
		}catch(Exception e) {
			
		}
		
	}

	@Override
	public void load() {
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			list = (ArrayList<Product>)ois.readObject();
			ois.close();
			
			}catch(Exception e) { 	//이렇게 파일이 존재한다면....
									/*   
									   	파일에 있는 내용을 읽어와서
										Employee를 생성하고 생성된 
										Employee들을 List에 저장한다.
									*/
				
			}
	}//위에 생성자에서 하던 걸 걍 깔끔하게 로드 메소드 하나 더 만든것 뿐임 복붙함

}
