//package thread.exam.test;
//
//class GoThread extends Superman implements Runnable{
//	
//	//start없네? 중간에 내부적인 뭔가가 끼었다는걸 알아야함
//	//이때부턴 실행주체가 내가 아니라 다른 무언가임
//	public void run() {
//		//쓰레드가 어떤 일을 하는지 여기다가 기술해야함
//		
//		for(int i=0; i<10; i++){
//			System.out.println("Go : "+i);
//		}
//	}
//}
//
//class ComeThread implements Runnable{
//	public void run() {
//		//쓰레드가 어떤 일을 하는지 여기다가 기술해야함
//		for(int i=0; i<10; i++){
//			System.out.println("Come : "+i);
//		}
//	}
//}
//
//
//public class GoComeThreadTest2 {
//
//	public static void main(String[] args) {
//	
//		GoThread go = new GoThread();
//		ComeThread come = new ComeThread();
//		
//		Thread t1 = new Thread(go);
//		Thread t2 = new Thread(come);
//		
//		go.start();
//		come.start();
//	}
//
//}
