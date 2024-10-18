package top_150_interview;

public class ZF_Game_Of_life {
    public static void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = rule(board, m, n, i, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = res[i][j];
            }
        }
    }

    public static int rule(int[][] board, int m, int n, int i, int j) {
        int cntLive = 0;
//        int cntDead = 0;
        if (i-1 >= 0) {

            if (j-1 >= 0) {
                cntLive += board[i-1][j-1];
//                cntDead += 1-board[i-1][j-1];
            }

            cntLive += board[i-1][j];
//            cntDead += 1-board[i-1][j];

            if (j+1 <= n-1) {
                cntLive += board[i-1][j+1];
//                cntDead += 1-board[i-1][j+1];
            }
        }

        if (j-1 >= 0) {
            cntLive += board[i][j-1];
//            cntDead += 1-board[i][j-1];
        }
        if (j+1 <= n-1) {
            cntLive += board[i][j+1];
//            cntDead += 1-board[i][j+1];
        }

        if (i+1 <= m-1) {
            if (j-1 >= 0) {
                cntLive += board[i+1][j-1];
//                cntDead += 1-board[i+1][j-1];
            }

            cntLive += board[i+1][j];
//            cntDead += 1-board[i+1][j];

            if (j+1 <= n-1) {
                cntLive += board[i+1][j+1];
//                cntDead += 1-board[i+1][j+1];
            }
        }


        if (board[i][j] == 1) {
            if (cntLive < 2) {
                return 0;
            } else if (cntLive == 2 || cntLive == 3) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (cntLive == 3) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
