package top_150_interview;

import java.util.ArrayList;
import java.util.List;
public class ZZM_SumNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        currentSum = currentSum * 10 + node.val;

        // Nếu là lá, trả về tổng hiện tại
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Nếu không, tính tổng từ các nhánh con
        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }


}
