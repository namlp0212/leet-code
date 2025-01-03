package top_150_interview;

import java.util.*;

public class ZZZA_SurroundedRegions {
    public void solve(char[][] board) {
        int numRow = board.length;
        int numCol = board[0].length;
        Queue<List<Integer>> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[numRow][numCol];

        // duyet bien, day vao queue
        for (int j = 0; j < numCol; j++) {
            if (board[0][j] == 'O') {
                q.add(Arrays.asList(0, j));
                visited[0][j] = true;
            }
            if (board[numRow-1][j] == 'O') {
                q.add(Arrays.asList(numRow-1, j));
                visited[numRow-1][j] = true;
            }
        }
        for (int i = 1; i < numRow-1; i++) {
            if (board[i][0] == 'O') {
                q.add(Arrays.asList(i, 0));
                visited[i][0] = true;
            }
            if (board[i][numCol-1] == 'O') {
                q.add(Arrays.asList(i, numCol-1));
                visited[i][numCol-1] = true;
            }
        }

        List<Integer> first;
        Integer r, c;
        while (!q.isEmpty()) {
            first = q.poll();
            r = first.get(0);
            c = first.get(1);

            if (r - 1 >= 0) {
                if (!visited[r-1][c] && board[r-1][c] == 'O') {
                    visited[r-1][c] = true;
                    q.add(Arrays.asList(r-1, c));
                }
            }

            if (c - 1 >= 0) {
                if (!visited[r][c-1] && board[r][c-1] == 'O') {
                    visited[r][c-1] = true;
                    q.add(Arrays.asList(r, c-1));
                }
            }

            if (r + 1 < numRow) {
                if (!visited[r+1][c] && board[r+1][c] == 'O') {
                    visited[r+1][c] = true;
                    q.add(Arrays.asList(r+1, c));
                }
            }

            if (c + 1 < numCol) {
                if (!visited[r][c+1] && board[r][c+1] == 'O') {
                    visited[r][c+1] = true;
                    q.add(Arrays.asList(r, c+1));
                }
            }
        }

        for (int i = 1; i < numRow-1; i++) {
            for (int j = 1; j < numCol-1; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
