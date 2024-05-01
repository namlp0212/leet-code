package a13_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int twoSum;
        List<List<Integer>> result = new ArrayList<>();
        int left, right;
        for (int i = 0; i < len; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            twoSum = -nums[i];
            left = i + 1;
            right = len - 1;
            while (left < right) {
                if (nums[left] + nums[right] == twoSum) {
                    List<Integer> items = Arrays.asList(nums[i], nums[left], nums[right]);
                    result.add(items);
                    while (left < len - 1 && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    while (right > 0 && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
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
        // [-1,0,1,2,-1,-4]
        int[] nums = new int[6];
        nums[0] = -1;
        nums[1] = 0;
        nums[2] = 1;
        nums[3] = 2;
        nums[4] = -1;
        nums[5] = -4;
//        nums[0] = 0;
//        nums[1] = 0;
//        nums[2] = 0;
        List<List<Integer>> result = threeSum(nums);
        for (List<Integer> items : result) {
            System.out.print("[ ");
            for (Integer i : items) {
                System.out.print(i + " ");
            }
            System.out.println("] ");
        }
    }
}
