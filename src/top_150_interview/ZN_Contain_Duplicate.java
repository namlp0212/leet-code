package top_150_interview;

import java.util.*;

public class ZN_Contain_Duplicate {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        List<Integer> arrIdx;
        Integer prevIdx;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                arrIdx = map.get(nums[i]);
                prevIdx = arrIdx.get(arrIdx.size() - 1);
                if (i - prevIdx <= k) {
                    return true;
                } else {
                    arrIdx.add(i);
                }
            } else {
                arrIdx = new ArrayList<>();
                arrIdx.add(i);
                map.put(nums[i], arrIdx);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums, 2));
    }
}
