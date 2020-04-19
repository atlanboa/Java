package array.basic.test;

public class ArrayTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[9];
		for(int i = 0; i < nums.length; i++) {
			nums[i] = 3*(1+i);
			System.out.println(nums[i] + " ");
		}//

		int sum = 0;
//		for(int i = 0; i < nums.length; i++) {
//			if(nums[i] % 2 == 0)  //i가 0부터 시작 
//				sum += nums[i];		
//		}
		for(int num : nums) {
			if(num % 2 == 0)  //i가 0부터 시작 
				sum += num;		
		}
		System.out.printf("홀수번째 요소들의 합은 :: %d\n",sum);
	}
}

