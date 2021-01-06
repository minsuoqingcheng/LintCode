package main.classify.special;

/**
 * 摩尔投票法
 */
@SuppressWarnings("ConstantConditions")
public class MajorityElement {

    public int majorityElement(int[] nums) {

        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            count += (candidate == num) ? 1 : -1;
        }

        return candidate;
    }

}
