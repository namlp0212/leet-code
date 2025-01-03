package top_150_interview;

import java.util.*;

public class ZZZ_NumberOfIsland {
    public int numIslands(char[][] grid) {
        int numRow = grid.length;
        int numCol = grid[0].length;

        int result = 0;
        boolean[][] visisted = new boolean[numRow][numCol];
        Queue<List<Integer>> q = new ArrayDeque<>();

        List<Integer> first;
        int r, c;
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                if (!visisted[i][j]) {
                    if (grid[i][j] == '1') {
                        result++;
                        q.add(Arrays.asList(i, j));
                        visisted[i][j] = true;

                        // loop queue
                        while (!q.isEmpty()) {
                            first = q.poll();
                            r = first.get(0);
                            c = first.get(1);

                            if (r - 1 >= 0) {
                                if (!visisted[r-1][c] && grid[r-1][c] == '1') {
                                    visisted[r-1][c] = true;
                                    q.add(Arrays.asList(r-1, c));
                                }
                            }

                            if (c - 1 >= 0) {
                                if (!visisted[r][c-1] && grid[r][c-1] == '1') {
                                    visisted[r][c-1] = true;
                                    q.add(Arrays.asList(r, c-1));
                                }
                            }

                            if (r + 1 < numRow) {
                                if (!visisted[r+1][c] && grid[r+1][c] == '1') {
                                    visisted[r+1][c] = true;
                                    q.add(Arrays.asList(r+1, c));
                                }
                            }

                            if (c + 1 < numCol) {
                                if (!visisted[r][c+1] && grid[r][c+1] == '1') {
                                    visisted[r][c+1] = true;
                                    q.add(Arrays.asList(r, c+1));
                                }
                            }

                        }
                    }
                }
            }
        }

        return result;
    }
}
