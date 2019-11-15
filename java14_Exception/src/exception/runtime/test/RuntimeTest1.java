package exception.runtime.test;

public class RuntimeTest1 {

	public static void main(String[] args) {
		String[] message = {
				"hello",
				"hello dd",
				"hello dfs"
				
		};
		//예외가 발생하면 그 블럭 자체가 실행안된다는 선입견을 가지고 있음
		//근데 실행해보면 알겠지만 3개까지 출력하고 4개부터 오류남
		
		int i=0;
		while(i<=3) {
			try {//예외발생안했을때 수행
			System.out.println(message[i]); //i=3일때 예외발생
			}catch(ArithmeticException e) {
				System.out.println("nice");
			}catch(ArrayIndexOutOfBoundsException e) {//그럼 여기로감
				System.out.println("Nice Catch!");
			}catch(Exception e) { //이 큰 범위부터 쓰는건 안됨 에러남
				System.out.println("gg");
			}//캐치는 여러개 쓸수 있지만 오류잡은 맨 첫번째 애만 출력됨
			//이러면 돌렸을 때 비정상적으로 종료가 안되는 것을 확인
			finally {
				System.out.println("계속 프린트");
			}
			i++;
		}

	}

}
