package a18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        int len = nums.length;
        long remainSum;
        int left, right;
        int i = 0;
        while (i < len) {
            int j = i + 1;
            while (j < len) {
                remainSum = (long)target - (nums[i] + nums[j]);
                left = j + 1; right = len - 1;

                while (left < right) {
                    if (nums[left] + nums[right] == remainSum) {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        while (left < len - 1 && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        left++;
                        while (right > 0 && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    } else if (nums[left] + nums[right]  < remainSum) {
                        while (left < right && left < len - 1 && nums[left] == nums[left + 1]) {
                            left ++;
                        }
                        left ++;
                    } else {
                        while (left < right && right > 0 && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        right--;
                    }
                }
                while (j < len - 1 && nums[j] == nums[j + 1]) {
                    j++;
                }
                j++;
            }

            while (i < len - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1_000_000_000,1000000000,1000000000,1000000000};

        List<List<Integer>> res = fourSum(nums, -294967296);

        System.out.println(res.size());
    }
}
