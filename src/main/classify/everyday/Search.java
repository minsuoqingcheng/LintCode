package main.classify.everyday;

/**
 * 数组被切分成两部分，肯定一部分有序，一部分无序！！！
 */
public class Search {

	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while (left <= right) {
			int middle = left + (right - left) / 2;

			if (nums[middle] == target) {
				return middle;
			}

			//有序部分
			if (nums[left] <= nums[middle]) {
				if (target < nums[middle] && target >= nums[left]) {
					right = middle - 1;
				} else {
					left = middle + 1;
				}
			//无序部分
			} else {
				//先升后降
				if (target > nums[middle] && target < nums[left]) {
					left = middle + 1;
				} else {
					// 升序部分
					right = middle - 1;
				}
			}
		}
		return -1;
	}

}
