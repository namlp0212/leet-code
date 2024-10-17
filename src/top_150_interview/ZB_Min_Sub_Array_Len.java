package top_150_interview;

import java.util.*;
public class ZB_Min_Sub_Array_Len {
    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = nums[0];
        while (start <= end) {
//            System.out.println("start = " + start + ", end = " + end + ", sum = " + sum + ", res = " + res);
            if (sum >= target) {
                res = Math.min(res, end-start+1);
                sum -= nums[start];
                start++;
            } else {
                end++;
                if (end == nums.length) {
                    break;
                }
                sum += nums[end];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }
}
