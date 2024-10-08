package top_150_interview;

public class b_Remove_Element {
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int k = 0;
        int i = nums.length - 1;
        while (k <= i && nums[k] != -1) {
            if (nums[k] == val) {
                while (i >= k && nums[i] == val) {
                    nums[i] = -1;
                    i--;
                }
                if (i < k) {
                    return k;
                } else {
                    nums[k] = nums[i];
                    nums[i] = -1;
                    k++;
                    i--;
                }
            } else {
                k++;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            System.out.print(nums[j] + " ");
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {2};
        removeElement(nums, 3);
    }
}
