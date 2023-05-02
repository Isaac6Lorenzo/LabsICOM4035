
public class Exercise01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Return the "centered" average of an array of ints, which we'll say is the
		 * mean average of the values, except ignoring the largest and smallest values
		 * in the array. If there are multiple copies of the smallest value, ignore just
		 * one copy, and likewise for the largest value. Use int division to produce the
		 * final average. You may assume that the array is length 3 or more.
		 * 
		 * examples: centeredAverage([1, 2, 3, 4, 100]) = 3 centeredAverage([1, 1, 5, 5,
		 * 10, 8,7]) = 5 centeredAverage([-10, -4, -2, -4, -2, 0]) = -3
		 * 
		 * URL https://codingbat.com/prob/p136585 
		 */

		int[] nums = {-10, -4, -2, -4, -2, 0};

		//int a = 0, b = 0;
		int ave, sum = 0;
		// for (int i = 0; i < nums.length; i++) {
		int count = nums.length;
		int max = nums[0];
		int min = nums[0];
		
		for(int i=0; i<count; i++) {
			if(nums[i] < min ) {
				min = nums[i];
			}
		}
		for(int i =0; i<count; i++) {
			if(nums[i] > max) {
				max = nums[i];
			}
		}
		
	for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		sum = sum - min - max;
		ave = sum/(count-2);
		System.out.println("min, max, sum, ave");
		System.out.println(min + ", " + max + ",  " + sum + ",  " + ave);

	}

}


//comments
/**

//for (int i = 0; i < nums.length; i++) {
//	if (max < nums[i]) {
//		max = nums[i];
//	}
	// }
//	a = Math.min.apply(null, nums);
//	b = Math.min.apply(null, nums);

//	for (int j = 0; j < nums.length; j++) {
//		
//		if(nums[i]>nums[j]) {
//			a = nums[i];
//			//System.out.println(a);
//		}
//		if(nums[i]<nums[j]) {
//			b = nums[i];
//			System.out.println(b);
//		}

//		a = Math.max(nums[i], nums[j]);
//		b = Math.min(nums[i], nums[j]);

//}
**/
