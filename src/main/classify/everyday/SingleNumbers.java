package main.classify.everyday;

public class SingleNumbers {

	public int[] singleNumbers(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum ^= nums[i];
		}
		int first = 1;
		while ((sum & first) == 0) {
			first <<= 1;
		}
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & first) == 0) {
				result[0] ^= nums[i];
			} else {
				result[1] ^= nums[i];
			}
		}
		return result;
	}

}
