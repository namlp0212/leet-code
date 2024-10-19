package top_150_interview;

import java.util.Arrays;
import java.util.Map;
import java.util.jar.Attributes;

public class ZO_Longest_Consecutive_Sequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int curLen = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]+1) {
                curLen++;
            } else if (nums[i] != nums[i-1]) {
                curLen = 1;
            }
            res = Math.max(res, curLen);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}
