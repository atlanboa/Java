package exception.user.test;

import java.io.IOException;

class ZeroBoom extends Exception{
	//뭐가 생략되있니? 생성자
	//생성자 안에는 super();생략되어 있겠지
	ZeroBoom(){
		this("ZeroBoom Exception...");
	}
	ZeroBoom(String message){
		super(message);
	}
}

class User{
	
	public void solv(int i, int j) throws ZeroBoom, IOException{
		
		System.out.println("solv() call");
		
		
		if(j==0) throw new ZeroBoom("분모가 0되면 안됨");
		//if(i==0) throw new IOException();
		
		
		System.out.println(i/j);
	}
}

public class UserTest5 {

	public static void main(String[] args) throws ZeroBoom, IOException{
		User user = new User();

		user.solv(10, 0); //폭탄은 호출한 여기서 처리함
		
		try {
			user.solv(10, 0); //폭탄은 호출한 여기서 처리함
		}catch(ZeroBoom e) {
			System.out.println(e.getMessage());
			
		}catch(IOException e) {
			
		}
	}
}

