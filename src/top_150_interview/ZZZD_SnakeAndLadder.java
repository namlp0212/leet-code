package top_150_interview;

import java.util.ArrayDeque;
import java.util.Queue;

public class ZZZD_SnakeAndLadder {
    class Node {
        int val;
        int step;

        public Node(int val, int step) {
            this.val = val;
            this.step = step;
        }
    }

    public int snakesAndLadders(int[][] board) {
        Queue<Node> queue = new ArrayDeque<>();
        int numOfRow = board.length;
        int target = numOfRow * numOfRow;
        boolean[] visited = new boolean[target + 1];

        int startVal = getValOfOrder(1, numOfRow, board);
        queue.add(new Node(startVal == -1 ? 1 : startVal, 0));
        visited[1] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int nextOrder = current.val + i;
                if (nextOrder > target) break;

                int nextVal = getValOfOrder(nextOrder, numOfRow, board);
                if (nextVal == -1) nextVal = nextOrder;

                if (nextVal == target) return current.step + 1;

                if (!visited[nextVal]) {
                    visited[nextVal] = true;
                    queue.add(new Node(nextVal, current.step + 1));
                }
            }
        }

        return -1;
    }

    public int getValOfOrder(int order, int numOfRow, int[][] board) {
        int row = (order - 1) / numOfRow;
        int col = (order - 1) % numOfRow;
        int actualRow = numOfRow - 1 - row;
        int actualCol = row % 2 == 0 ? col : numOfRow - 1 - col;
        return board[actualRow][actualCol];
    }
}
