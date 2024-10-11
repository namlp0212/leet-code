package top_150_interview;

import java.time.LocalDate;
import java.time.*;
import java.time.format.*;

import java.util.*;

public class d_Remove_Duplicates_II {
    public static int removeDuplicates(int[] nums) {
        int k = 1;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                nums[k] = nums[i];
                k++;
                cnt = 1;
            } else {
                if (cnt < 2) {
                    nums[k] = nums[i];
                    k++;
                }
                cnt++;
            }
        }

        return k;
    }


}
