package top_150_interview;

import java.util.*;

public class c_Remove_Duplicates {
    public static int removeDuplicates(int[] nums) {
        int k = 0;
        if (nums.length == 0) return k;

        int[] res = new int [nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != res[k]) {
                res[++k] = nums[i];
            }
        }

        for (int i = 0; i <= k; i++) {
            nums[i] = res[i];
        }
        return k+1;
    }

    public static void main(String [] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(new Integer(2));
        list.add(new Integer(1));
        list.add(new Integer(0));

        list.remove(list.indexOf(0));

        System.out.println(list);
    }
}
