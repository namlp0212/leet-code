package top_150_interview;

import java.util.LinkedList;
import java.util.Queue;

public class i_Jump_game {
    static class Node {
        int idx;
        int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    public static boolean canJumpV1(int[] nums) {
        boolean[] check = new boolean[nums.length];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, nums[0]));
        check[0] = true;
        boolean canJump = false;

        int val;
        int idx;
        while (!queue.isEmpty()) {
            Node first = queue.poll();

            idx = first.idx;
            val = first.val;

            if (idx == nums.length - 1) {
                return true;
            } else {
                for (int i = idx + 1; i <= idx + val && i < nums.length; i++) {
                    if (!check[i]) {
                        queue.add(new Node(i, nums[i]));
                        check[i] = true;
                    }
                }
            }
        }

        return canJump;
    }

    public static boolean canJumpV2(int[] nums) {
        int len = nums.length;
        boolean[] check = new boolean[len];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        check[0] = true;
        boolean canJump = false;

        int val;
        int idx;
        while (!queue.isEmpty()) {
            idx = queue.poll();
            val = nums[idx];

            if (idx == len - 1) {
                return true;
            } else {
                if (idx + val >= len - 1) return true;
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
                }
            }
        }

        return canJump;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJumpV2(nums));
    }
}
