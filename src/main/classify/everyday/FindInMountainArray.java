package main.classify.everyday;

public class FindInMountainArray {

	public int findInMountainArray(int target, MountainArray mountainArr) {
		int peek = findPeek(mountainArr);
		int index = binarySearch(target, mountainArr, 0, peek, false);
		if (index != -1) {
			return index;
		}
		return binarySearch(target, mountainArr, peek+1, mountainArr.length() - 1, true);
	}

	private int findPeek(MountainArray mountainArray) {
		int left = 0;
		int length = mountainArray.length();
		int right = length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (mountainArray.get(mid) < mountainArray.get(mid+1)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	private int binarySearch(int target, MountainArray mountainArray, int start, int end, boolean reverse) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int value = mountainArray.get(mid);
			if (value == target) {
				return mid;
			} else if (value < target) {
				if (!reverse) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else {
				if (!reverse) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return -1;
	}
}


interface MountainArray {
	public int get(int index);
	public int length();
}