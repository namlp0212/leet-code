package top_150_interview;

public class e_Majority_Element {
    public int majorityElement(int[] nums) {
        int cur = nums[0];
        int count = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cur) {
                count++;
            } else {
                count--;
            }

            if (count == -1) {
                cur = nums[i];
                count = 0;
            }
        }

        return cur;
    }
}
