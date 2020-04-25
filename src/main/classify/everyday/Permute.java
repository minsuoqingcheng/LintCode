package main.classify.everyday;

import java.util.ArrayList;
import java.util.List;

public class Permute {

	public List<List<Integer>> permute(int[] nums) {
		int length = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		if (length == 0) {
			return res;
		}
		boolean[] used = new boolean[length];
		dfs(nums, length, 0, used, new ArrayList<>(), res);
		return res;
	}

	private void dfs(int[] nums, int length, int depth, boolean[] used, List<Integer> path, List<List<Integer>> res) {
		if (depth == length) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = 0; i < length; i++) {
			if (!used[i]) {
				path.add(nums[i]);
				used[i] = true;
				dfs(nums, length, depth + 1, used, path, res);

				used[i] = false;
				path.remove(path.size() - 1);
			}
		}

	}


}
