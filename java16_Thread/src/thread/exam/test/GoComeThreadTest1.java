package thread.exam.test;

/*
 * 현재 돌고있는 쓰레드의 이름을 함께 출력하는 방법
 * 
 */

//class GoThread extends Thread{
class GoThread implements Runnable{
	//start없네? 중간에 내부적인 뭔가가 끼었다는걸 알아야함
	//이때부턴 실행주체가 내가 아니라 다른 무언가임
	public void run() {
		//쓰레드가 어떤 일을 하는지 여기다가 기술해야함
		
		for(int i=0; i<10; i++){
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+":"+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //1초 얘는 왜 throws를 못하나? run 메소드는 public void run() 외에 어떤 것도 못함
			/*
			 * 이 뒤에 run() throws 뭐시기 못한다고 그래서 트라이 캐치만 가능
			 */
			
		}
	}
}

class ComeThread implements Runnable{
	public void run() {
		
		//쓰레드가 어떤 일을 하는지 여기다가 기술해야함
		for(int i=0; i<10; i++){
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+":" +i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
}


public class GoComeThreadTest1 {

	public static void main(String[] args) {
	
		GoThread go = new GoThread();
		ComeThread come = new ComeThread();
		
		Thread t1 = new Thread(go, "경태");
		Thread t2 = new Thread(come, "영심");
		
		t1.start();
		t2.start();
	}

}
