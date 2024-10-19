package top_150_interview;
import java.util.*;
public class ZP_Summary_Ranges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();

        int curStart = nums[0];
        int curEnd = nums[0];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1] + 1) {
                curEnd = nums[i];
            } else {
                if (curEnd == curStart) {
                    sb.append(curEnd);
                } else {
                    sb.append(curStart).append("->").append(curEnd);
                }
                res.add(sb.toString());

                curStart = nums[i];
                curEnd = nums[i];
                sb = new StringBuilder();
            }
        }

        if (curEnd == curStart) {
            sb.append(curEnd);
        } else {
            sb.append(curStart).append("->").append(curEnd);
        }
        res.add(sb.toString());

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
    }
}
