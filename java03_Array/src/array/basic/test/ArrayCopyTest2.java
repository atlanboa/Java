package array.basic.test;

/*
 * 1. Re-Sizing이 안된다
 *    : 사이즈가 변형되게 되면 새로운 배열이 만들어지고
 *      이전의 배열객체는 참조가 끊어져버린다.
 * 2. 다른 사이즈를 가진 배열의 데이터를 copy 해 올수는 있다.
 *    System.arraycopy(a,a,a,a,a);
 *    
 */
public class ArrayCopyTest2 {

	public static void main(String[] args) {
		//1.선언 + 생성 + 초기화
		int[] source = {1,2,3,4,5,6,7,8,9,10};
		int[] target = {66,55,44,33,22,11};
		
		//2. arraycopy()를 이용해서
		
		//3. for 이용해서 출력.......1,2,3,66,55,44,33,22,11
		
		System.arraycopy(target, 0, source, 4, target.length);
		for(int num : source) {
			System.out.println(num+ " ");
		}
		
	}

	

}
