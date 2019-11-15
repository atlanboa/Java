package thread.exam.test;

import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JOptionPane;

/*
 *특정한 숫자를 입력하기 전에는 카운팅 작업이 병렬적으로 진행되지 않았다.
 *숫자 입력 작업과 카운트
 */
class CountThread extends Thread{
	public void run() {
		//일종의 카운팅 작업 5 4 3 2 1 ...
		for(int i=10; i>0; i--) {
			
			try {
				//sleep함수가 스태틱이어서 그냥 갖다쓰는거임 Math.abs처럼!!!
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}
}


//프로세스가 뭐야 여기서? 클래스임
/*
 * 그럼 메인메소드를 갖고있는 하나의 클래스를 프로세스라 하는구나
 * 
 * 프로세스에서는 뭘 가져? 메인메소드 가짐
 * 메인메소드도 쓰레드임
 * 하나의 프로세스는 무조건 하나의 스레드를 가짐 데몬 스레드
 *  
 * 지금까지는 싱글스레드 모드였음 메인 무조건 있었자나
 * 
 * 그걸 이제는 일을 '병행적인 일처리'를 하도록 할꺼임
 * 
 * 카운팅 작업을 하는 놈을 따로 만들어
 */
public class InputThreadTest2 {

	public static void main(String[] args) {
		
		CountThread ct = new CountThread();
		ct.start();
		//스윙 쓴거임
		String input = JOptionPane.showInputDialog("숫자를 입력하세요");
		System.out.println("입력한 값은" + input);
		
		
		
	
	}

}
