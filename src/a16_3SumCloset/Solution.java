package a16_3SumCloset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int twoSum;
        int result = 0, delta = Integer.MAX_VALUE;
        int left, right;
        int abs;
        for (int i = 0; i < len; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            twoSum = target - nums[i];
            left = i + 1;
            right = len - 1;
            while (left < right) {
                abs = Math.abs(nums[i] + nums[left] + nums[right] - target);
                if (abs < delta) {
                    delta = abs;
                    result = nums[i] + nums[left] + nums[right];
                }
                if (nums[left] + nums[right] == twoSum) {
                    return target;
                } else if (nums[left] + nums[right] < twoSum) {
                    while (left < len - 1 && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else {
                    while (right > 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[4];
        nums[0] = -1;
        nums[1] = 2;
        nums[2] = 1;
        nums[3] = 4;

        System.out.println(threeSumClosest(nums, 1));
    }

}
