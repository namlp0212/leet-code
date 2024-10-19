package top_150_interview;

import java.util.HashMap;
import java.util.Map;

public class ZL_Two_Sum {
    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[] {map.get(target - numbers[i]), i};
            } else {
                map.put(numbers[i], i);
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        System.out.println(twoSum(nums, 6));
    }
}
