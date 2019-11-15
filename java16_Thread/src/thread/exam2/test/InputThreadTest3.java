package thread.exam2.test;

import javax.swing.JOptionPane;

/*
 * 자원을 공유한다 - 커뮤니케이션을 할 수 있다.
 */


//카운팅 작업
class CountThread extends Thread{
	//가지려면 필드에 선언해야 된다고 했자나!!!!!!!!!!!
	private InputThreadTest3 itt;
	
	public CountThread(InputThreadTest3 itt) {
		this.itt = itt;
	}

	public void run() {
	for(int i=10; i>0; i--) {
		
		if(itt.checkInput) break;
		try {
			//sleep함수가 스태틱이어서 그냥 갖다쓰는거임 Math.abs처럼!!!
			Thread.sleep(1000); //zzzzZZZ
			
			System.out.println(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	if(!itt.checkInput) {
		System.out.println("카운트 끝남");
		System.exit(0);
	}
}}

//숫자를 입력 작업
class InputThread extends Thread{

	private InputThreadTest3 itt;
	
	public InputThread(InputThreadTest3 itt) {
		this.itt = itt;
	}
	public void run() {
		String input = JOptionPane.showInputDialog("숫자를 입력하세요");
		System.out.println("입력한 값은" + input);
		
		itt.checkInput = true;
	}
}	
	
	





//checkInput을 갖고있는 객체 전체를 인자로 던져주면 됨
//뭘 던져줄까? 레퍼런스 값 갖고 있는 this
//스레드가 프로세스를 가짐 우리는 크다 작다의 개념이 박혀있음..
/*
 * 스레드가 프로세스를 가지려면 통으로 넣으주면 됨
 * 지금은 메인이라 안되지만 메인아니면 this 쓰면 됨
 */

//자원은 하나가아니라 여러개를 가질 수 있자나
public class InputThreadTest3 {

	//정확하게 하려면 static빼고 해야함
	/*static*/ boolean checkInput = false; //기본값 false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InputThreadTest3 itt = new InputThreadTest3();
		
		CountThread ct = new CountThread(itt);
		InputThread it = new InputThread(itt);
		ct.start();
		it.start();
	}

}
