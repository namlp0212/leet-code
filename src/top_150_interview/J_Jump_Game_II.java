package top_150_interview;

import java.util.LinkedList;
import java.util.Queue;

public class J_Jump_Game_II {
    public static int jump(int[] nums) {
        int len = nums.length;
        boolean[] check = new boolean[len];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        check[0] = true;
        int jumStep = 0;

        int val;
        int idx;
        while (!queue.isEmpty()) {
            idx = queue.poll();

            if (idx >= len - 1) {
                return jumStep;
            } else {
                val = nums[idx];
                if (idx + val >= len - 1) return jumStep + 1;
                int maxJump = 0;
                int maxIdx = 0;

                for (int i = idx+1; i <= idx + val; i++) {
                    if (nums[i] + i > maxJump) {
                        maxJump = nums[i] + i;
                        maxIdx = i;
                    }
                }
                if (maxIdx != 0) {
                    queue.add(maxIdx);
                    jumStep++;
                }
            }
        }

        return jumStep;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 2, 5, 2};
        System.out.println(jump(nums));
    }
}
