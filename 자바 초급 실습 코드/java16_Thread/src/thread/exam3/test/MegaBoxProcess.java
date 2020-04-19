package thread.exam3.test;
/*
 * 두개 이상의 쓰레드 들이 동작
 * 
 * 프로세스의 자원을 공유하는 상황
 * -> 이때 동기화 처리를 안하게 되면 어떤 문제점이 발생하는지를 보여주는 로직을 작성
 * -> 동기화처리를 하고 나서 안정적으로 작업이 진행되는지를 확인
 */

class MegaboxCustom implements Runnable{
	public void run() {
		//좌석을 예매하는 기능을 작성
		try {
			reservation();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @throws InterruptedException 
	 * 여기 걸어도 메소드만 거는게 아니고 객체 자체에 락이 걸리는 거임 
	 */
	private synchronized void reservation() throws InterruptedException {
		String customName = Thread.currentThread().getName();
		System.out.println(customName+ ", 좌석 예매 시작합니다...");
		
		if(MegaBoxProcess.seat==false) {
			Thread.sleep(1000);//슬립했기에 여기 상순이 같이 들어오게됨 그럼 이안에 두명이 옴
			//지금은 1초여서 그럼 엄청 큰 시간이면 상순도 똑같이 쉬기 때문에 겹칠일이 없음
			
			System.out.println(customName+ ", 좌석 예매 성공");
			MegaBoxProcess.seat = true;
		}else {//이미 예매가 끝난 좌석인 경우
			 System.out.println(customName+ ", 이미 예매된 좌석입니다.");
		}
	}
}


public class MegaBoxProcess {

	static boolean seat;
	
	public static void main(String[] args) {
		MegaboxCustom custom = new MegaboxCustom();
		Thread t1 = new Thread(custom, "효리");
		Thread t2 = new Thread(custom, "상순");
		
		//둘다 같은 놈이라 우선순위 똑같..
		t1.start(); //효리가 먼저 예매를 하러 출발
		t2.start();
	}

}
